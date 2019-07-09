package items;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private List<Sentence> sentences;

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for(Sentence sentence : sentences){
            words.addAll(sentence.getWords());
        }
        return words;
    }

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