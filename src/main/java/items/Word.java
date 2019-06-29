package items;

import readers.Reader;

import java.util.ArrayList;
import java.util.List;

public class Word {
    public String word;

    public String toString(){
        return word;
    }

    public List<Item> getLetters() {
        return letters;
    }

    public List<Item> letters = new ArrayList<>();

    public Word(String word) {
        this.word = word;
        String[] strings = word.split("");
        for (String s : strings) {
            for (int i = 0;i < s.length(); i++){
                Letter letter = new Letter(Character.toString(s.charAt(i)));
                letters.add(letter);
            }
        }
    }

    public String getWord() {
        return word;
    }
}
