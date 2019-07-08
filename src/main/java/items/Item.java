package items;

import java.util.List;

public abstract class Item {

    private List<Symbol> symbolList;

    public Item(List<Symbol> symbolList) {
        this.symbolList = symbolList;
    }

    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    public abstract boolean isWord();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol symbol : symbolList) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}
