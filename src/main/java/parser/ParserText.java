package parser;

import items.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
            StringBuilder sb = new StringBuilder();
            if (isWord(s)) {
                items.add(parseWord(s));
            } else {
                char[] charArray = s.toCharArray();
                for (char c : charArray) {
                    if (Character.isLetter(c)) {
                        sb.append(c);
                    } else {
                        if (!sb.toString().isEmpty()) {
                            items.add(parseWord(sb.toString()));
                            sb.setLength(0);
                        }

                        items.add(parseSentencePart(String.valueOf(c)));


                    }
                }
                if (sb.toString().equals("")) {
                    continue;
                } else {
                    sb.append(items.add(parseWord(sb.toString())));
                }

//                items.add(parseSentencePart(s));
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
        if (chars[0] == '.') {
            return false;
        }
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

    public List<String> alphSort(Text text) throws IOException {
        Set<String> set = new TreeSet<>();
        for (Word word : text.getWords()) {
            set.add(word.toString().substring(0, 1).toUpperCase() + word.toString().substring(1));
        }
        List<String> list = new ArrayList<>(set);
        list.set(0, " " + list.get(0));
        for (int n = 0; n < list.size() - 1; n++) {
            if (list.get(n).substring(0, 1).equals(" ")) {
                if (!list.get(n).substring(1, 2).equals(list.get(n + 1).substring(0, 1))) {
                    list.set(n + 1, " " + list.get(n + 1));
                }
            } else {
                if (!list.get(n).substring(0, 1).equals(list.get(n + 1).substring(0, 1))) {
                    list.set(n + 1, " " + list.get(n + 1));
                }
            }
        }
        return list;
        }
    }
