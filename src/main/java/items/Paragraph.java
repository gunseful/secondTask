package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {
    String paragraph;
    Map<Integer, Item> marks = new TreeMap<Integer, Item>();
    List<Sentence> sentences = new ArrayList<>();

    public String getParagraph() {
        return paragraph;
    }

    public String toString() {
        return paragraph;
    }

    public Map<Integer, Item> getMarks() {
        return marks;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        String[] sentenceArray = paragraph.split("(\\?\\s|\\.\\s|!\\s)+");
        for (String sent : sentenceArray) {
            Sentence sentence = new Sentence(sent);
            sentences.add(sentence);
        }
        Pattern pattern = Pattern.compile("(\\!\\s|\\.\\s|\\?\\s)");
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            Mark mark = new Mark(matcher.group());
            this.marks.put(matcher.start(), mark);
        }
    }

}



