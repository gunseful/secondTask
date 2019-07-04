package items;

import java.util.List;

public class Text {
    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    private List<Paragraph> paragraphs;

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