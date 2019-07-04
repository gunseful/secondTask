package items;

import java.util.List;

public class Word {
    private List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Letter h : letters){
            sb.append(h);
        }
        return sb.toString();
    }
}
