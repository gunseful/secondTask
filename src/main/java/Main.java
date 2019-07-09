
import items.Text;
import parser.AlexParser;
import parser.Parser;
import parser.ParserText;
import readers.Reader;

import java.io.IOException;


public class Main {
    private static final Reader READER = new Reader();

    private static final Parser ILUXA_PARSER = new ParserText();
    private static final Parser ALEX_PARSER = new AlexParser();

    public static void main(String[] args) throws IOException {
        String textSource = READER.read("src/text.txt");

        final Text alexText = ALEX_PARSER.parse(textSource);
        Text text = ILUXA_PARSER.parse(textSource);

        System.out.printf("Is Alex text equals to original? [%s]%n", alexText.toString().equals(textSource) ? "YES" : "NO");
        System.out.printf("Is gunself text equals to original? [%s]%n", text.toString().equals(textSource) ? "YES" : "NO");
        System.out.printf("Is Alex equals to gunself? [%s]%n", alexText.toString().equals(text.toString()) ? "YES" : "NO");

//        System.out.println(text.toString());
//        System.out.println(textSource);
//        System.out.println(text.toString().equals(textSource)+"\n");
//        text.getWords();
//        text.getParagraphs().get(0).getWords();
//        text.getParagraphs().get(0).getSentences().get(0).getWords().get(1);

//        ILUXA_PARSER.alphSort(text).forEach(System.out::println);
    }
}