

import Items.Paragraphs;
import Items.Words;
import readers.Reader;

import java.io.IOException;

public class Main {

    private static final Reader READER = new Reader();

    public static void main(String[] args) throws IOException {
        String sourceText = READER.read("src/text.txt");

        Words words = new Words(sourceText);
        String fromWords = words.backToText(words.getItems());// Собираем слова обратно в текст
        if (!fromWords.equals(sourceText)) throw new RuntimeException("Text is not equal");
        // words.alphabeticalSortingPrint();  //Сразу выводит в консоль все слова из текста в алфавитном порядке без повторений
        Paragraphs parapraphs = new Paragraphs(sourceText);
        String fromParagraph = parapraphs.backToText(parapraphs.getItems());// Собираем параграфы обратно в текст
        if (!fromParagraph.equals(sourceText)) throw new RuntimeException("Text is not equal");
        // C классами Sententence и Symbols можно проделать тоже самое что и с теми примерами что сверху
    }
}
