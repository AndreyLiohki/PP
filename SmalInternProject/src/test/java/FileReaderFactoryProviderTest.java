import factory.FileReaderFactory;
import factory.FileReaderFactoryProvider;
import factory.JsonFileReaderFactory;
import factory.XMLFileReaderFactory;
import factory.YAMLFileReaderFactory;
import factory.PlainTextFileReaderFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileReaderFactoryProviderTest {

    @Test
    public void testGetFactory_json() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("json");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of JsonFileReaderFactory", factory instanceof JsonFileReaderFactory);
    }

    @Test
    public void testGetFactory_xml() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("xml");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of XMLFileReaderFactory", factory instanceof XMLFileReaderFactory);
    }

    @Test
    public void testGetFactory_yaml() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("yaml");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of YAMLFileReaderFactory", factory instanceof YAMLFileReaderFactory);
    }

    @Test
    public void testGetFactory_yml() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("yml");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of YAMLFileReaderFactory", factory instanceof YAMLFileReaderFactory);
    }

    @Test
    public void testGetFactory_txt() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("txt");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of PlainTextFileReaderFactory", factory instanceof PlainTextFileReaderFactory);
    }

    @Test
    public void testGetFactory_zip() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("json.zip");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of JsonFileReaderFactory", factory instanceof JsonFileReaderFactory);
    }

    @Test
    public void testGetFactory_gz() {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory("yaml.gz");
        assertNotNull("Factory should not be null", factory);
        assertTrue("Factory should be an instance of YAMLFileReaderFactory", factory instanceof YAMLFileReaderFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFactory_unsupported() {
        FileReaderFactoryProvider.getFactory("unsupported");
    }
}