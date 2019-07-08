package items;

import java.util.List;

public class Word extends Item {

    public Word(List<Symbol> symbols) {
        super(symbols);
    }

    @Override
    public boolean isWord() {
        return true;
    }

}
