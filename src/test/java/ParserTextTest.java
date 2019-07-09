import items.Text;
import org.junit.Assert;
import org.junit.Test;
import parser.ParserText;
import readers.Reader;

import java.io.IOException;

public class ParserTextTest {
    private static final Reader READER = new Reader();
    @Test
    public void parse() throws IOException {
        String textSource = READER.read("src/text.txt");
        ParserText parserText = new ParserText();
        Text text = parserText.parse(textSource);
        Assert.assertEquals(text.toString(), textSource);
    }
}