package items;

public class Letter {
    private Character letter;

    public Letter(Character letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
