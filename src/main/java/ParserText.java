import items.Item;
import items.Paragraph;
import items.Sentence;

import java.io.IOException;
import java.util.*;

public class ParserText {
    public List<Paragraph> paragraphs = new ArrayList<>();

    public List<Paragraph> parse(String text) {
        String[] paragraphsArray = text.split("\t");
        for (int i = 0; i < paragraphsArray.length; i++) {
            Paragraph paragraph = new Paragraph(paragraphsArray[i]);
            paragraphs.add(paragraph);
        }
        return paragraphs;
    }

    public String backFromParagraphsToText() {

        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            sb.append(paragraph.getParagraph() + "\t");
        }
        return sb.toString();
    }

    public String backFromSentencesToText() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : this.paragraphs) {
            StringBuilder y = new StringBuilder();
            for (int i = 0; i < paragraph.getSentences().size(); i++) {
                y.append(paragraph.getSentences().get(i).getSentence());
            }
            for (Map.Entry<Integer, Item> pair : paragraph.getMarks().entrySet()) {
                y.insert(pair.getKey(), pair.getValue());
            }
            sb.append(y);
            sb.append("\t");
        }
        return sb.toString();
    }

    public String backFromWordsToText() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            StringBuilder y = new StringBuilder();
            for (Sentence sentence : paragraph.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    StringBuilder h = new StringBuilder();
                    h.append(sentence.getMarks().get(i));
                    h.append(sentence.getWords().get(i).getWord());
                    y.append(h);
                }
                y.append(sentence.getMarks().get(sentence.getMarks().size() - 1));
            }
            for (Map.Entry<Integer, Item> pair : paragraph.getMarks().entrySet()) {
                y.insert(pair.getKey(), pair.getValue().toString().substring(0, 1));
            }
            sb.append(y);
            sb.append("\t");
        }
        return sb.toString();
    }

    public String backFromLettersToText() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            StringBuilder y = new StringBuilder();
            for (Sentence sentence : paragraph.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    StringBuilder h = new StringBuilder();
                    h.append(sentence.getMarks().get(i));
                    for (int j = 0; j < sentence.getWords().get(i).getLetters().size(); j++) {
                        h.append(sentence.getWords().get(i).getLetters().get(j));
                    }
                    y.append(h);
                }
                y.append(sentence.getMarks().get(sentence.getMarks().size() - 1));
            }
            for (Map.Entry<Integer, Item> pair : paragraph.getMarks().entrySet()) {
                y.insert(pair.getKey(), pair.getValue().toString().substring(0, 1));
            }
            sb.append(y);
            sb.append("\t");
        }
        return sb.toString();
    }

    public List<String> alphSort() throws IOException {
        List<String> list = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (Paragraph par : paragraphs) {
            for (Sentence sentence : par.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    words.add(sentence.getWords().get(i).toString());
                }
            }

            Set<String> set = new HashSet<String>(words);
            list.addAll(set);

            for (int i = 0; i < list.size(); i++) {
                String word = list.get(i).toString().substring(0, 1).toUpperCase() + list.get(i).toString().substring(1);
                list.set(i, word);
            }
            Collections.sort(list);
            String firstWord = list.get(0);
            list.set(0, " " + firstWord);
            for (int n = 0; n < list.size() - 1; n++) {
                if (list.get(n).substring(0, 1).equals(" ")) {
                    if (!list.get(n).substring(1, 2).equals(list.get(n + 1).substring(0, 1))) {
                        String y = " " + list.get(n + 1);
                        list.set(n + 1, y);
                    } else {
                    }
                } else {
                    if (!list.get(n).substring(0, 1).equals(list.get(n + 1).substring(0, 1))) {
                        String y = " " + list.get(n + 1);
                        list.set(n + 1, y);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        return list;
    }
}


