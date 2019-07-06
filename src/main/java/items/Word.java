package items;

import java.util.List;

public class Word {

    private List<Symbol> symbols;

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getLetters() {
        return symbols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Symbol h : symbols){
            sb.append(h);
        }
        return sb.toString();
    }
}
