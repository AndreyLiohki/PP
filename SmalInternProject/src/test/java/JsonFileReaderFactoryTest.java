import factory.JsonFileReaderFactory;
import filehandler.JSONFileHandler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JsonFileReaderFactoryTest {

    @Test
    public void testCreateFileReader() {
        JsonFileReaderFactory factory = new JsonFileReaderFactory();
        JSONFileHandler fileReader = factory.createFileReader();

        assertNotNull("FileReader should not be null", fileReader);
        assertTrue("FileReader should be an instance of JSONFileHandler", fileReader instanceof JSONFileHandler);
    }
}