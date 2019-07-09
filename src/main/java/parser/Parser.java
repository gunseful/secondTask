package parser;

import items.Text;

import java.util.List;

public interface Parser {

    Text parse(String sourceText);

    List<String> alphSort(Text text);
}
