package items;

import java.util.List;

public class Sentence {

    private List<Item> items;
    private List<Word> words;

    public Sentence(List<Item> items, List<Word> words) {
        this.words = words;
        this.items = items;
    }

    public List<Word> getWords() {
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<items.size(); i++) {
            sb.append(items.get(i).toString());
            int w = sb.toString().length();
            if(!sb.toString().substring(w-1).equals(".")) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}