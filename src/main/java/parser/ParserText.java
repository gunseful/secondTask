package parser;

import items.*;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class ParserText {

    public Text parse(String sourceText) {
        return new Text(stream(sourceText.split("\\t"))
            .map(this::parseToSentence)
            .collect(Collectors.toList()));
    }

    private Paragraph parseToSentence(String a) {
        String[] list = a.split("(\\?\\s|\\.\\s|!\\s)+");
        List<String> marks = new ArrayList<>();
        Pattern pattern = Pattern.compile("(!\\s|\\.\\s|\\?\\s)");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            marks.add(matcher.group().substring(0, 1));
        }
        List<Sentence> sentences = new ArrayList<>();
        int count = 1;
        for (String y : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(y);
            if (list.length != count) {
                sb.append(marks.get(count - 1));
            }
            count++;
            String u = sb.toString();
            sentences.add(parseItem(u));
        }
        return new Paragraph(sentences);
    }

    private Sentence parseItem(String a) {
        String[] list = a.split("\\s");
        List<Item> items = new ArrayList<>();
        for (String s : list) {
            if (isWord(s)) {
                items.add(parseWord(s));
            } else {
                items.add(parseSentencePart(s));
            }
        }
        return new Sentence(items);
    }

    private Word parseWord(String s) {
        return new Word(s.chars().mapToObj(e -> new Symbol((char) e))
            .collect(Collectors.toList()));
    }

    private SentenceParts parseSentencePart(String s) {
        return new SentenceParts(s.chars().mapToObj(e -> new Symbol((char) e))
            .collect(Collectors.toList()));
    }

    private boolean isWord(String s) {
        char[] chars;
        chars = s.toCharArray();
        if (chars[chars.length - 1] == '.') {
            return false;
        }
        for (char c : chars) {
            if (!Character.isLetter(c) && c != '-' & c != '.' & c != '\'') {
                return false;
            }
        }
        return true;
    }

    public void alphSort(String text) throws IOException {
        List<Paragraph> paragraphs = parse(text).getParagraphs();
        List<String> allWords = new ArrayList<>();
        for (Paragraph aParagraph : paragraphs) {
            for (Sentence sentence : aParagraph.getSentences()) {
                for (int i = 0; i < sentence.getItems().size(); i++) {
                    final Item item = sentence.getItems().get(i);
                    if (item.isWord()) {
                        allWords.add(item.toString());
                    }
                }
            }
        }
        for (String st : allWords) {
            st.replaceAll(" ", "");
        }
        Set<String> wordsNoRepetitions = new HashSet<String>(allWords);
        List<String> words = new ArrayList<>(wordsNoRepetitions);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).isEmpty()) {
                words.remove(i);
            }
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i).substring(0, 1).toUpperCase() + words.get(i).substring(1);
            words.set(i, word);
        }
        Collections.sort(words);
        String firstWord = words.get(0);
        words.set(0, " " + firstWord);
        for (int n = 0; n < words.size() - 1; n++) {
            if (words.get(n).substring(0, 1).equals(" ")) {
                if (!words.get(n).substring(1, 2).equals(words.get(n + 1).substring(0, 1))) {
                    String y = " " + words.get(n + 1);
                    words.set(n + 1, y);
                }
            } else {
                if (!words.get(n).substring(0, 1).equals(words.get(n + 1).substring(0, 1))) {
                    String y = " " + words.get(n + 1);
                    words.set(n + 1, y);
                }
            }
        }
        for (String word : words) {
            System.out.println(word);
        }
    }

}