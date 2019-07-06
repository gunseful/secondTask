package items;

public class Symbol {
    private Character symbol;

    public Symbol(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
