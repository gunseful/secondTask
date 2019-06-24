

import Items.Paragraphs;
import Items.Words;
import readers.Reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = new Reader();

        Words words = new Words(reader.read("src/text.txt"));
        words.getItems(); // Получаем коллекцию слов из текста
        words.backToText(words.getItems());     // Собираем слова обратно в текст
        // words.alphabeticalSortingPrint();  //Сразу выводит в консоль все слова из текста в алфавитном порядке без повторений
        Paragraphs parapraphs = new Paragraphs(reader.read("src/text.txt"));
        parapraphs.getItems(); // Получаем коллекцию параграфов из текста
        parapraphs.backToText(parapraphs.getItems()); // Собираем параграфы обратно в текст

        // C классами Sententence и Symbols можно проделать тоже самое что и с теми примерами что сверху
    }
}
