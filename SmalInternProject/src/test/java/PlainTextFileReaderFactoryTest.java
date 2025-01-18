import factory.PlainTextFileReaderFactory;
import filehandler.PlainTextReader;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PlainTextFileReaderFactoryTest {

    @Test
    public void testCreateFileReader() {
        PlainTextFileReaderFactory factory = new PlainTextFileReaderFactory();
        PlainTextReader fileReader = factory.createFileReader();

        assertNotNull("FileReader should not be null", fileReader);
        assertTrue("FileReader should be an instance of PlainTextReader", fileReader instanceof PlainTextReader);
    }
}