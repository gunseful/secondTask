package items;

public class Item {
    public String item;

    public Item(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
