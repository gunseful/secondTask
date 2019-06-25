package items;

import java.util.ArrayList;
import java.util.List;

public class Paragraphs implements Items {

    public Sentences sentences;

    List<String> paragraphs = new ArrayList<>();
    public Paragraphs(String text) {
        this.sentences = new Sentences(text);
        String sentText = sentences.backToText();
        String[] paragraphsArray = sentText.split("\t");
        for (int i = 0; i < paragraphsArray.length; i++) {
            paragraphs.add(paragraphsArray[i]);
        }
    }

    public List<String> getItems() {
        return paragraphs;
    }

    @Override
    public String backToText() {
        StringBuilder sb = new StringBuilder();
        for (String string : paragraphs) {
            sb.append(string + "\t");
        }
        return sb.toString();
    }
}
