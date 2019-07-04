
import items.*;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParserText {
    Text parse(String sourceText) {
        String[] list = sourceText.split("\\t");
        List<Paragraph> paragraphs = new ArrayList<>();
        for (String a : list) {
            paragraphs.add(parseToSentence(a));
        }
        return new Text(paragraphs);
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
        int count=1;
        for (String y : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(y);
            if (list.length != count) {
                sb.append(marks.get(count - 1));
            }
            count++;
            String u = sb.toString();
            sentences.add(parseToWords(u));
        }
        return new Paragraph(sentences);
    }

    private Sentence parseToWords(String a) {
        String[] list = a.split("\\s");
        List<Word> words = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        for(String s : list){
            if (isWord(s)) {
                words.add(parseToLetters(s));
                items.add(new Item(""));
            }else{
                char[] symbols = s.toCharArray();
                StringBuilder word = new StringBuilder();
                StringBuilder mark = new StringBuilder();
                for (char symbol : symbols) {
                    if (Character.isLetter(symbol)) {
                        word.append(symbol);
                    } else {
                        mark.append(symbol);
                    }
                }
                words.add(parseToLetters(word.toString()));
                Item item = new Item(mark.toString());
                items.add(item);
            }
        }
        return new Sentence(items, words);
    }

    private Word parseToLetters(String s) {
        char[] charArray = s.toCharArray();
        List<Letter> letters = new ArrayList<>();
        for (Character v : charArray) {
            Letter letter = new Letter(v);
            letters.add(letter);
        }
        return new Word(letters);
    }

    private boolean isWord(String s){
        char[] chars;
        chars = s.toCharArray();
        if (chars[chars.length - 1] == '.') {
            return false;
        }
        for (char c : chars)
            if (!Character.isLetter(c) & c != '-' & c != '.' & c != '\'') {
                return false;
            }
        return true;
    }

    void alphSort(String text) throws IOException {
        List<Paragraph> paragraphs = parse(text).getParagraphs();
        List<String> allWords = new ArrayList<>();
        for (Paragraph aParagraph : paragraphs) {
            for (Sentence sentence : aParagraph.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    allWords.add(sentence.getWords().get(i).toString());
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