import factory.XMLFileReaderFactory;
import filehandler.XMLFileHandler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class XMLFileReaderFactoryTest {

    @Test
    public void testCreateFileReader() {
        XMLFileReaderFactory factory = new XMLFileReaderFactory();
        XMLFileHandler fileReader = factory.createFileReader();

        assertNotNull("FileReader should not be null", fileReader);
        assertTrue("FileReader should be an instance of XMLFileHandler", fileReader instanceof XMLFileHandler);
    }
}