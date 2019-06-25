package items;

import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentences implements Items {

    public Words words;

    List<String> sentences = new ArrayList<>();
    Map<Integer, String> marks = new TreeMap<Integer, String>();

    public Sentences(String text) {
        this.words = new Words(text);
        String wordsText = words.backToText();
        Pattern pattern = Pattern.compile("(\\!\\s|\\.\\s|\\?\\s)");
        Matcher matcher = pattern.matcher(wordsText);
        while (matcher.find()) {
            marks.put(matcher.start(), matcher.group());
        }
        String[] sentence = wordsText.split("(\\?|\\.\\s|!)+");
        for (String sent : sentence) {
            sentences.add(sent);
        }
    }

    public Sentences(ArrayList<String> list) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i);
            iterator.setText(text);
            int start = iterator.first();
            for (int end = iterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = iterator.next()) {
                sentences.add(text.substring(start, end));
            }
        }
    }

    @Override
    public List<String> getItems() {
        return sentences;
    }

    @Override
    public String backToText() {
        StringBuilder sb = new StringBuilder();
        for (String str : sentences) {
            sb.append(str);
        }
        for (Map.Entry<Integer, String> pair : marks.entrySet()) {
            sb.insert(pair.getKey(), pair.getValue());
        }
        return sb.toString();
    }
}
