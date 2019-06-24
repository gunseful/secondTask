package Items;

import java.util.*;
import java.util.regex.Pattern;

public class Words implements Items {
    List<String> words = new ArrayList<>();
    List<String> marks = new ArrayList<String>();
    List<String> list = new ArrayList<>();

    public Words(String text) {
        Pattern pattern = Pattern.compile("[^a-zA-Z[-]]+");
        String[] strings = pattern.split(text);
        for (String s : strings) {
            words.add(s);
        }
        Pattern pattern2 = Pattern.compile("[a-zA-Z[-]]+");
        String[] strings2 = pattern2.split(text);
        for (String s : strings2) {
            marks.add(s);
        }
    }

    public Words(ArrayList<String> list) {
        Pattern pattern = Pattern.compile("[^a-zA-Z[-]]+");
        for (int i = 0; i < list.size(); i++) {
            String[] strings = pattern.split(list.get(i));
            for (String s : strings) {
                words.add(s);
            }
        }
        Pattern pattern2 = Pattern.compile("[a-zA-Z[-]]+");
        for (int i = 0; i < list.size(); i++) {
            String[] strings2 = pattern2.split(list.get(i));
            for (String s : strings2) {
                marks.add(s);
            }
        }
    }

    @Override
    public List<String> getItems() {
        return words;
    }

    public List<String> getMarks() {
        return marks;
    }

    @Override
    public String backToText(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(marks.get(i));
            sb.append(list.get(i));
        }

        return sb.toString();
    }

    public void alphabeticalSortingPrint() {
        Set<String> set = new HashSet<>(words);
        list.addAll(set);

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).substring(0, 1).toUpperCase() + list.get(i).substring(1);
            list.set(i, str);
        }
        Collections.sort(list);
        for (int n = 0; n < list.size() - 1; n++) {
            if (list.get(n).substring(0, 1).equals(" ")) {
                if (!list.get(n).substring(1, 2).equals(list.get(n + 1).substring(0, 1))) {
                    String y = " " + list.get(n + 1);
                    list.set(n + 1, y);
                } else {

                }
            } else {
                if (!list.get(n).substring(0, 1).equals(list.get(n + 1).substring(0, 1))) {
                    String y = " " + list.get(n + 1);
                    list.set(n + 1, y);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
