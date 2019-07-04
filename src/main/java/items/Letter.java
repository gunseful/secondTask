package items;

public class Letter {
    public Character letter;

        public Letter(Character letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
