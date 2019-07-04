package items;

import java.util.List;

public class Paragraph {
    public List<Sentence> getSentences() {
        return sentences;
    }

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    private List<Sentence> sentences;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(Sentence sent : sentences){
            String u = sent.toString();
            sb.append(u);
            if(sentences.size()!=count) {
            sb.append(" ");
            }
            count++;
        }
        return sb.toString();
    }
}