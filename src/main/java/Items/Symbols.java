package Items;

import java.util.ArrayList;
import java.util.List;

public class Symbols implements Items {
    List<String> symbols = new ArrayList<>();

    public Symbols(String text) {
        java.lang.String[] strings = text.split("");
        for (java.lang.String s : strings) {
            symbols.add(s);
        }
    }

    public Symbols(ArrayList<String> list) {
        ArrayList<java.lang.String> symbols = new ArrayList<java.lang.String>();
        for (int i = 0; i < list.size(); i++) {
            java.lang.String[] strings = list.get(i).split("");
            for (java.lang.String s : strings) {
                symbols.add(s);
            }
        }
    }

    @Override
    public String backToText(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : symbols) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Override
    public List<String> getItems() {
        return symbols;
    }
}
