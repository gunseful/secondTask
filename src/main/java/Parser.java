import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class Parser {

    public String parseToText(ArrayList<String> y) {
        String str = "";
        for (int i = 0; i < y.size(); i++) {
            str += y.get(i);
        }
        return str;
    }

    public ArrayList<String> parseToParagraphs(String str) {

        String[] Paragraphs = str.split("\t");
        ArrayList<String> ParagraphsArray = new ArrayList<String>();
        for (int i = 0; i < Paragraphs.length; i++) {
            ParagraphsArray.add(Paragraphs[i]);
        }
        return ParagraphsArray;
    }

    public ArrayList<String> parseSentences(ArrayList<String> paragraphs) {
        ArrayList<String> sentencesArray = new ArrayList<String>();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        for (int i = 0; i < paragraphs.size(); i++) {
            String text = paragraphs.get(i);
            iterator.setText(text);
            int start = iterator.first();
            for (int end = iterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = iterator.next()) {
                sentencesArray.add(text.substring(start, end));
            }
        }
        return sentencesArray;
    }

    public ArrayList<String> parseToWords(ArrayList<String> sentences) {
        ArrayList<String> words = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[^a-zA-Z[-]]+");
        for (int i = 0; i < sentences.size(); i++) {
            String[] strings = pattern.split(sentences.get(i));
            for (String s : strings) {
                words.add(s);
            }
        }
        return words;
    }

    public ArrayList<String> parseToMarks(ArrayList<String> sentences) {
        ArrayList<String> symbols = new ArrayList<String>();
        Pattern pattern2 = Pattern.compile("[a-zA-Z[-]]+");
        for (int i = 0; i < sentences.size(); i++) {
            String[] strings = pattern2.split(sentences.get(i));
            for (String s : strings) {
                symbols.add(s);
            }
        }
        return symbols;
    }

    public String parseWordsAndSymbolsToText(ArrayList<String> words, ArrayList<String> marks) {
        String text = "";
        for (int i = 0; i < words.size(); i++) {
            text += (marks.get(i) + words.get(i));
        }
        return text;
    }

    public ArrayList<String> parseToSymbols(ArrayList<java.lang.String> sentences) {
        ArrayList<java.lang.String> symbols = new ArrayList<java.lang.String>();
        for (int i = 0; i < sentences.size(); i++) {
            java.lang.String[] strings = sentences.get(i).split("");
            for (java.lang.String s : strings) {
                symbols.add(s);
            }
        }
        return symbols;
    }

}

