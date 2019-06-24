package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader implements ReaderInterface{
    public String read(String fileaddress) throws IOException {
        String text = "";
        BufferedReader readerFromFile = new BufferedReader(new FileReader(fileaddress));
        List<String> textArray = new ArrayList<String>();
        String stringFromText = null;
        while ((stringFromText = readerFromFile.readLine())!=null){
            textArray.add(stringFromText);
        }
        for (String s : textArray){                    // Собираем весь текст в одну строку
            text += s+"\t";
        }
        return text;
    }
}
