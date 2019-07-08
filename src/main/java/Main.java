
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
        System.out.println(text.toString().equals(textSource));

        Sentence sntnc = text.getParagraphs().get(2).getSentences().get(1);
        System.out.println(sntnc);
//        Word str = text.getParagraphs().get(2).getSentences().get(1).getItems().get(1);
//        System.out.println(str);
        Symbol chr = text.getParagraphs().get(2).getSentences().get(1).getItems().get(1).getSymbolList().get(0);
        System.out.println(chr+"\n");

                parserText.alphSort(textSource);

        String secontTextSource = "Говно, залупа, пенис, хер, давалка, хуй, блядина. " +
                "Такова была первая строка в битве между Оксимироном и ДжониБоем. Что сказать, гениально!";
        Text secondText = parserText.parse(secontTextSource);
        System.out.println(secondText.getParagraphs().get(0));
        System.out.println(secondText.getParagraphs().get(0).getSentences().get(1));
//        System.out.println(secondText.getParagraphs().get(0).getSentences().get(1).getWords().get(1));
//        System.out.println(secondText.getParagraphs().get(0).getSentences().get(1).getWords().get(1).getLetters().get(2)+"\n");

                parserText.alphSort(secontTextSource);
    }
}