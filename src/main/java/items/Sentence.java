package items;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence {
    private String sentence;
    public List<Word> words = new ArrayList<>();
    public List<Item> marks = new ArrayList<Item>();

    public List<Word> getWords() {
        return words;
    }

    public List<Item> getMarks() {
        return marks;
    }

    public String toString() {
        return sentence;
    }

    public Sentence(String sentence) {
        this.sentence = sentence;
        Pattern pattern = Pattern.compile("[^a-zA-Z[-]]+");
        String[] strings = pattern.split(sentence);
        for (String s : strings) {
            Word word = new Word(s);
            words.add(word);
        }
        Pattern pattern2 = Pattern.compile("[a-zA-Z[-]]+");
        String[] strings2 = pattern2.split(sentence);
        for (String s : strings2) {
            Mark mark = new Mark(s);
            marks.add(mark);
        }
    }
    public String getSentence() {
        return sentence;
    }
}
