import readers.Reader;

import java.io.IOException;


public class Main {

    public static final Reader READER = new Reader();

    public static void main(String[] args) throws IOException {
        String textSource = READER.read("src/text.txt");

        ParserText parserText = new ParserText();

        parserText.parse(textSource);   //Парсим текст
        System.out.println(parserText.paragraphs.get(2)); //Получаем параграф №3 и выводим на консоль
        System.out.println(parserText.paragraphs.get(2).getSentences().get(0)); //Получаем первое предложение параграфа №3 и выводим на консоль
        System.out.println(parserText.paragraphs.get(2).getSentences().get(0).getWords().get(3)); //Получаем 4 слово первого предложения параграфа №3 и выводим на консоль
        System.out.println(parserText.paragraphs.get(2).getSentences().get(0).getWords().get(3).getLetters().get(2)); //Получаем 3 букву 4го слова первого предложения параграфа №3 и выводим на консоль

        //методы собирающие текст из слов, предложений, параграфов, букв:
        parserText.backFromWordsToText();
        parserText.backFromSentencesToText();
        parserText.backFromParagraphsToText();
        parserText.backFromLettersToText();
        System.out.println(parserText.backFromWordsToText().equals(textSource));
        System.out.println(parserText.backFromSentencesToText().equals(textSource));
        System.out.println(parserText.backFromParagraphsToText().equals(textSource));
        System.out.println(parserText.backFromLettersToText().equals(textSource));

//        parserText.alphSort(); //Сортирует все слова текста по алфавиту и выводит, каждая новая буква - с красной строки






    }
}
