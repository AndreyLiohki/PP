import filewriter.JSONWriter;
import filewriter.PlainTextWriter;
import filewriter.ResultWriter;
import filewriter.YAMLWriter;
import org.junit.jupiter.api.Test;
import writerfactory.ResultWriterFactory;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class ResultWriterFactoryTest {

    @Test
    public void testGetJSONWriter() {
        ResultWriter writer = ResultWriterFactory.getWriter("json");
        assertTrue("Expected a JSONWriter",writer instanceof JSONWriter);
    }

    @Test
    public void testGetPlainTextWriter() {
        ResultWriter writer = ResultWriterFactory.getWriter("txt");
        assertTrue("Expected a PlainTextWriter",writer instanceof PlainTextWriter);
    }

    @Test
    public void testGetYAMLWriter() {
        ResultWriter writer = ResultWriterFactory.getWriter("yaml");
        assertTrue("Expected a YAMLWriter", writer instanceof YAMLWriter);
    }

    @Test
    public void testGetWriterWithUnsupportedFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ResultWriterFactory.getWriter("unsupported");
        });
        assertEquals("Unsupported format: unsupported", exception.getMessage());
    }
}