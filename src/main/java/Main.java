

import items.Paragraphs;
import items.Words;
import readers.Reader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final Reader READER = new Reader();

    public static void main(String[] args) throws IOException {
        String text = READER.read("src/text.txt");
        Paragraphs paragraphs = new Paragraphs(text);
        paragraphs.sentences.words.symbols.getItems(); //получаем коллекцию символов из текста
        paragraphs.sentences.words.getItems(); //получаем коллекцию слов из текста
        paragraphs.sentences.getItems(); //получаем коллекцию предложений из текста
        paragraphs.getItems(); //получаем коллекцию предложений из текста
        //чтобы собрать коллекцию слов в текст вызываем метод backToText у words
        paragraphs.sentences.words.backToText();
        //чтобы отсортировать коллекцию слов по алфавиту, убрать повторяющиеся слова,
        //и сделать чтобы каждая новая буква была с красной строки
        //используем метод alphabeticalSortingPrint()
        paragraphs.sentences.words.alphabeticalSortingPrint();









    }
}
