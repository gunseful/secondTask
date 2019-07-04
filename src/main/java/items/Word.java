package items;

import java.util.List;

public class Word {
    private List<Character> letters;

    public Word(List<Character> letters) {
        this.letters = letters;
    }

    public List<Character> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Character h : letters){
            sb.append(h);
        }
        return sb.toString();
    }
}
