package items;

import java.util.List;

public class Sentence {

    private List<Item> items;

    public Sentence(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString());
            int w = sb.toString().length();
            if (!sb.toString().substring(w - 1).equals(".")) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}