package items;

public class Symbol {
    private Character letter;

    public Symbol(Character letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
