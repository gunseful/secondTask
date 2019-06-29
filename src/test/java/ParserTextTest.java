import org.junit.Assert;
import org.junit.Test;
import readers.Reader;

import java.io.IOException;

public class ParserTextTest {

    @Test
    public void backFromParagraphsToText() throws IOException {
        Reader reader = new Reader();
        String text = reader.read(("src/text.txt"));
        ParserText parser = new ParserText();
        parser.parse(text);
        String parserText = parser.backFromParagraphsToText();
        Assert.assertEquals(text, parserText);
    }

    @Test
    public void backFromSentencesToText() throws IOException {
        Reader reader = new Reader();
        String text = reader.read(("src/text.txt"));
        ParserText parser = new ParserText();
        parser.parse(text);
        String parserText = parser.backFromSentencesToText();
        Assert.assertEquals(text, parserText);
    }

    @Test
    public void backFromWordsToText() throws IOException {
        Reader reader = new Reader();
        String text = reader.read(("src/text.txt"));
        ParserText parser = new ParserText();
        parser.parse(text);
        String parserText = parser.backFromWordsToText();
        Assert.assertEquals(text, parserText);
    }

    @Test
    public void backFromLettersToText() throws IOException {
        Reader reader = new Reader();
        String text = reader.read(("src/text.txt"));
        ParserText parser = new ParserText();
        parser.parse(text);
        String parserText = parser.backFromLettersToText();
        Assert.assertEquals(text, parserText);
    }
}