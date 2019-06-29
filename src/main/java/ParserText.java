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
        StringBuilder fullText = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            StringBuilder paragraphsText = new StringBuilder();
            for (Sentence sentence : paragraph.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    StringBuilder sentencesText = new StringBuilder();
                    sentencesText.append(sentence.getMarks().get(i));
                    sentencesText.append(sentence.getWords().get(i).getWord());
                    paragraphsText.append(sentencesText);
                }
                paragraphsText.append(sentence.getMarks().get(sentence.getMarks().size() - 1));
            }
            for (Map.Entry<Integer, Item> pair : paragraph.getMarks().entrySet()) {
                paragraphsText.insert(pair.getKey(), pair.getValue().toString().substring(0, 1));
            }
            fullText.append(paragraphsText);
            fullText.append("\t");
        }
        return fullText.toString();
    }

    public String backFromLettersToText() {
        StringBuilder fullText = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            StringBuilder sentencesText = new StringBuilder();
            for (Sentence sentence : paragraph.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    StringBuilder wordsText = new StringBuilder();
                    wordsText.append(sentence.getMarks().get(i));
                    for (int j = 0; j < sentence.getWords().get(i).getLetters().size(); j++) {
                        wordsText.append(sentence.getWords().get(i).getLetters().get(j));
                    }
                    sentencesText.append(wordsText);
                }
                sentencesText.append(sentence.getMarks().get(sentence.getMarks().size() - 1));
            }
            for (Map.Entry<Integer, Item> pair : paragraph.getMarks().entrySet()) {
                sentencesText.insert(pair.getKey(), pair.getValue().toString().substring(0, 1));
            }
            fullText.append(sentencesText);
            fullText.append("\t");
        }
        return fullText.toString();
    }

    public List<String> alphSort() throws IOException {
        List<String> words = new ArrayList<>();
        List<String> allWords = new ArrayList<>();
        for (Paragraph aParagraph : paragraphs) {
            for (Sentence sentence : aParagraph.getSentences()) {
                for (int i = 0; i < sentence.getWords().size(); i++) {
                    allWords.add(sentence.getWords().get(i).toString());
                }
            }

            Set<String> wordsNoRepetitions = new HashSet<String>(allWords);
            words.addAll(wordsNoRepetitions);

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
                    } else {
                    }
                } else {
                    if (!words.get(n).substring(0, 1).equals(words.get(n + 1).substring(0, 1))) {
                        String y = " " + words.get(n + 1);
                        words.set(n + 1, y);
                    }
                }
            }
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i));
            }
        }
        return words;
    }
}


