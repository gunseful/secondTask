package items;

import java.util.List;

public class Item {
    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    protected List<Symbol> symbolList;

    public Item(List<Symbol> symbolList) {
        this.symbolList = symbolList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<symbolList.size(); i++) {
            sb.append(symbolList.get(i));
        }
        return sb.toString();
    }
}
