package items;

import java.util.List;

public class Sentence {
    public List<Word> getWords() {
        return words;
    }
    private List<String> items;

    public Sentence(List<String> items, List<Word> words) {
        this.words = words;
        this.items = items;
    }

    private List<Word> words;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<words.size(); i++){
            if(items.get(i).equals("(")){
                sb.append(items.get(i));
                sb.append(words.get(i));
            }else{
            sb.append(words.get(i).toString());
            sb.append(items.get(i));}
            int w = sb.toString().length();
            if(!sb.toString().substring(w-1).equals(".")) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}