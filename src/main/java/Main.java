

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //создаем ридер
        Reader reader = new Reader();
        //создаем парсер
        Parser parser = new Parser();
        //читаем файл, извлекаем текст и переводим его в параграфы:
        ArrayList<String> paragraphs = parser.parseToParagraphs(reader.read("C:\\Users\\Ares\\IdeaProjects\\secondTask\\text.txt"));
        System.out.println(paragraphs);
        //переводим параграфы в предложения:
        ArrayList<String> sentence = parser.parseSentences(paragraphs);
        System.out.println(sentence);
        //пробуем собрать назад в текст:
        System.out.println(parser.parseToText(sentence));
        System.out.println(parser.parseToText(paragraphs));
        //переводим предложения в слова и в знаки препинания:
        ArrayList<String> words = parser.parseToWords(sentence);
        System.out.println(words);
        ArrayList<String> marks = parser.parseToMarks(sentence);
        //собираем слова и знаки препинания назад в текст:
        System.out.println(parser.parseWordsAndSymbolsToText(words,marks));
        //переводим предложения в символы
        ArrayList<String> symbols = parser.parseToSymbols(sentence);
        System.out.println(symbols);
        //собираем символы в текст
        System.out.println(parser.parseToText(symbols));

        //Выполнения задания №6

        Sort sort = new Sort();
        // читаем файл, извлекаем текст, переводим в слова, сортируем слова по алфавиту,
        // если слово начинается с новой буквы, оно с красной строки)
        sort.sorting("C:\\Users\\Ares\\IdeaProjects\\secondTask\\text.txt");
        // печатаем отсорированный список:
        for(int i = 0; i<sort.sorting("C:\\Users\\Ares\\IdeaProjects\\secondTask\\text.txt").size(); i++){
            System.out.println(sort.sorting("C:\\Users\\Ares\\IdeaProjects\\secondTask\\text.txt").get(i));
        }



    }
}
