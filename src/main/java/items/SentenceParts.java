package items;

import java.util.List;

public class SentenceParts extends Item {

    public SentenceParts(List<Symbol> symbolList) {
        super(symbolList);
    }

    @Override
    public boolean isWord() {
        return false;
    }
}
