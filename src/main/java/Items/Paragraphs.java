package Items;

import java.util.ArrayList;
import java.util.List;

public class Paragraphs implements Items {
    List<String> paragraphs = new ArrayList<>();

    public Paragraphs(String text) {
        String[] Paragraphs = text.split("\t");
        for (int i = 0; i < Paragraphs.length; i++) {
            paragraphs.add(Paragraphs[i]);
        }
    }

    public List<String> getItems() {
        return paragraphs;
    }

    @Override
    public String backToText(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String string : paragraphs) {
            sb.append(string + "\\t");
        }
        return sb.toString();
    }
}
