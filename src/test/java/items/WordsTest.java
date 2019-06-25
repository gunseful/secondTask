package items;

import org.junit.Assert;
import org.junit.Test;
import readers.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordsTest {

    @Test
    public void backToText() throws IOException {
        Reader reader = new Reader();
        String text = reader.read(("src/text.txt"));
        Paragraphs paragraphs = new Paragraphs(text);
        String wordsText = paragraphs.sentences.words.backToText();
        Assert.assertEquals(wordsText, text);
    }
}