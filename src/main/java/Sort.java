import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public ArrayList<String> sort(String s) throws IOException {
        Reader reader = new Reader();
        Parser parser = new Parser();
        ArrayList<String> words = new ArrayList<String>();
        words = parser.parseToWords(parser.parseSentences(parser.parseToParagraphs(reader.read("C:\\Users\\Ares\\IdeaProjects\\secondTask\\text.txt"))));

        for(int i = 0; i<words.size();i++){
            String str = words.get(i).toLowerCase();
            words.set(i,str);
        }
        Collections.sort(words);
        for(int n = 0; n<words.size()-1; n++){
            if(words.get(n).substring(0,1).equals(" ")){
                if(!words.get(n).substring(1,2).equals(words.get(n+1).substring(0,1))){
                    String y = " "+words.get(n+1);
                    words.set(n+1, y);
                }else{

                }
            }else{
                if(!words.get(n).substring(0,1).equals(words.get(n+1).substring(0,1))){
                    String y = " "+words.get(n+1);
                    words.set(n+1, y);
                }
            }

        }
        return words;
    }
}

