package items;

public class Item {
    private String item;

    public Item(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
