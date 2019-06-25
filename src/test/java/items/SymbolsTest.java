package items;

import org.junit.Assert;
import org.junit.Test;
import readers.Reader;

import java.io.IOException;
import java.util.List;

public class SymbolsTest {

    @Test
    public void backToText() throws IOException {
        Reader reader = new Reader();
        String text = reader.read(("src/text.txt"));
        Paragraphs paragraphs = new Paragraphs(text);
        String symbolsText = paragraphs.sentences.words.symbols.backToText();
        Assert.assertEquals(symbolsText, text);
    }
}