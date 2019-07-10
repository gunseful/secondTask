package parser;

import items.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Character.isLetter;
import static java.lang.System.lineSeparator;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class AlexParser implements Parser {

    private static final Pattern SENTENCE_PATTERN = Pattern.compile(".+[.;!?]");

    @Override
    public Text parse(String sourceText) {
        String[] list = sourceText.split("\\t");
        List<Paragraph> paragraphs = new ArrayList<>();
        for (String a : list) {
            paragraphs.add(parseParagraph(a));
        }
        return new Text(paragraphs);
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
            List<Character> list = new ArrayList<>();
            for (char c : matcher.group().toCharArray()){
                list.add(c);
            }
            for (int i = 1; i<list.size(); i++) {

                if (isLetter(list.get(i-1))) {
                    word.append(list.get(i-1));
                } else {
                    if (word.length() != 0 && list.get(i-1).equals('.')||list.get(i-1).equals('\'')||list.get(i-1).equals('-') && isLetter(list.get(i))) {
                        word.append(list.get(i-1));
                    }else {
                        if (word.length() != 0) {
                            items.add(new Word(parseSymbols(word.toString())));
                            word = new StringBuilder();
                        }
                    }
                    if(word.length()==0){
                    items.add(parseSentencePart(list.get(i-1)));}
                }
                if (list.size()-1==i && isLetter(list.get(i)) && isLetter(list.get(i-1))) {
                    word.append(list.get(i));}
                if (list.size()-1==i && !isLetter(list.get(i))) {
                    items.add(new Word(parseSymbols(word.toString())));
                    word = new StringBuilder();
                    items.add(parseSentencePart(list.get(i)));}
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
