package readers;

import java.io.IOException;

public interface ReaderInterface {
    String read(String fileAddress) throws IOException;
}
