package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence {

    private List<Item> items;

    public Sentence(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for(Item item : items){
            if(item.isWord()){
                words.add((Word) item);
            }
        }
        return words;
    }

    @Override
    public String toString() {
       return items.stream().map(Item::toString).collect(Collectors.joining());
    }
}