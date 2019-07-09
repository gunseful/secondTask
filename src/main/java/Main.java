
import items.*;
import parser.ParserText;
import readers.Reader;

import java.io.IOException;


public class Main {
    private static final Reader READER = new Reader();

    public static void main(String[] args) throws IOException {
        String textSource = READER.read("src/text.txt");

        ParserText parserText = new ParserText();
        Text text = parserText.parse(textSource);
        System.out.println(text.toString());
        System.out.println(textSource);
        System.out.println(text.toString().equals(textSource)+"\n");
        text.getWords();
        text.getParagraphs().get(0).getWords();
        text.getParagraphs().get(0).getSentences().get(0).getWords().get(1);

        parserText.alphSort(text).forEach(System.out::println);
    }
}