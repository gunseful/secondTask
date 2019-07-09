package parser;

import items.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isLetter;
import static java.lang.System.lineSeparator;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class AlexParser implements Parser {

    private static final Pattern SENTENCE_PATTERN = Pattern.compile(".+[.;!?]");

    @Override
    public Text parse(String sourceText) {
        return new Text(Collections.singletonList(parseParagraph(sourceText)));
    }

    @Override
    public List<String> alphSort(Text text) {
        return new TreeSet<>(text.getWords()).stream().map(Item::toString).collect(toList());
    }

    private Paragraph parseParagraph(String text) {
        return new Paragraph(stream(text.split(lineSeparator()))
            .map(this::parseSentence)
            .collect(toList()));
    }

    private Sentence parseSentence(String text) {
        final Matcher matcher = SENTENCE_PATTERN.matcher(text);
        List<Item> items = new ArrayList<>();
        while (matcher.find()) {
            StringBuilder word = new StringBuilder();
            for (char c : matcher.group().toCharArray()) {
                if (isLetter(c)) {
                    word.append(c);
                } else {
                    if (word.length() != 0) {
                        items.add(new Word(parseSymbols(word.toString())));
                        word = new StringBuilder();
                    }
                    items.add(parseSentencePart(c));
                }
            }
            if (word.length() != 0) {
                items.add(new Word(parseSymbols(word.toString())));
            }

        }
        return new Sentence(items);
    }

    private SentenceParts parseSentencePart(char c) {
        return new SentenceParts(Collections.singletonList(new Symbol(c)));
    }

    private List<Symbol> parseSymbols(String word) {
        return word.chars().mapToObj(e -> new Symbol((char) e)).collect(toList());
    }
}
