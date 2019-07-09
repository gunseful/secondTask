package items;

import java.util.List;

public class Word extends Item implements Comparable<Word> {

    public Word(List<Symbol> symbols) {
        super(symbols);
    }

    @Override
    public boolean isWord() {
        return true;
    }

    @Override
    public int compareTo(Word o) {
        return toString().compareToIgnoreCase(o.toString());
    }
}
