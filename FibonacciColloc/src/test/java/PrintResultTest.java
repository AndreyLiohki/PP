import org.example.printResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class PrintResultTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @Before
    public void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrint() {
        long fibonacciNumber = 5;
        int number = 5;

        printResult.print(fibonacciNumber, number);

        String expectedOutput = number + " число Фиббоначи равно " + fibonacciNumber + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }
}