package items;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<Paragraph> paragraphs;

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for(Paragraph paragraph : paragraphs){
            words.addAll(paragraph.getWords());
        }
        return words;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Paragraph paragraph : paragraphs){
            sb.append(paragraph.toString());
            sb.append("\t");
        }
        return sb.toString();
    }
}