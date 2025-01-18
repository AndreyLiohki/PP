import factory.YAMLFileReaderFactory;
import filehandler.YAMLFileHandler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class YAMLFileReaderFactoryTest {

    @Test
    public void testCreateFileReader() {
        YAMLFileReaderFactory factory = new YAMLFileReaderFactory();
        YAMLFileHandler fileReader = factory.createFileReader();

        assertNotNull("FileReader should not be null", fileReader);
        assertTrue("FileReader should be an instance of YAMLFileHandler", fileReader instanceof YAMLFileHandler);
    }
}