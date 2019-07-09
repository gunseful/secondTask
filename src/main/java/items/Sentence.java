package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<items.size(); i++) {
            sb.append(items.get(i-1).toString());
            if(i==items.size()-1){
                sb.append(items.get(i));
            }
            String[] num = new String[]{"1","2","3","4","5","6","7","8","9","0"};
            int w = sb.toString().length();
            if(Arrays.asList(num).contains(items.get(i-1).toString()) && Arrays.asList(num).contains(items.get(i).toString())){
            } else {
                if (items.get(i - 1).toString().equals("(")) {
                } else {
                    if (items.get(i - 1).toString().equals(")") && items.get(i).equals(".") || items.get(i).equals(",")) {
                    } else {
                        if (items.get(i).toString().equals(")")) {
                        } else {
                            if (items.get(i).toString().equals(",") || items.get(i).toString().equals(".") || items.get(i).toString().equals(":")) {
                            } else {
                                    sb.append(" ");

                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}