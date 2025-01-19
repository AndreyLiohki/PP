import org.example.EnterData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class EnterDataTest {

    private InputStream originalIn;

    @Before
    public void setUp() {
        originalIn = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    public void testReadDataValidInput() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = EnterData.readData();
        assertEquals(5, result);
    }

    @Test
    public void testReadDataInvalidInputAboveLimit() {
        String input = "104\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = EnterData.readData();
        assertEquals(10, result);
    }

    @Test
    public void testReadDataInvalidInputBelowZero() {
        String input = "-1\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = EnterData.readData();
        assertEquals(10, result);
    }

    @Test
    public void testReadDataBoundaryValueZero() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = EnterData.readData();
        assertEquals(0, result);
    }

    @Test
    public void testReadDataBoundaryValueTwentyTwo() {
        String input = "22\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = EnterData.readData();
        assertEquals(22, result);
    }
}