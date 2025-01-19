import org.example.EnterData;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class EnterDataTest {

    @Test
    public void testReadData_ValidInput() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = EnterData.readData();
        assertEquals(5, result);
    }

    @Test
    public void testReadData_InvalidInput_TooHigh() {
        String input = "105\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = EnterData.readData();
        assertEquals(3, result);
    }

    @Test
    public void testReadData_InvalidInput_TooLow() {
        String input = "-1\n50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = EnterData.readData();
        assertEquals(50, result);
    }
}