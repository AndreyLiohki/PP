import org.example.FibonacciNumbers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciNumberTest {
    private FibonacciNumbers fibonacci;

    @Before
    public void setUp() {
        fibonacci = new FibonacciNumbers();
    }

    @Test
    public void testFibonacciOfZero() {
        fibonacci.setNumOfFibonacciNumbers(0);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 0 should be 0", 0, result);
    }

    @Test
    public void testFibonacciOfOne() {
        fibonacci.setNumOfFibonacciNumbers(1);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 1 should be 1", 1, result);
    }

    @Test
    public void testFibonacciOfTwo() {
        fibonacci.setNumOfFibonacciNumbers(2);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 2 should be 1", 1, result);
    }

    @Test
    public void testFibonacciOfThree() {
        fibonacci.setNumOfFibonacciNumbers(3);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 3 should be 2", 2, result);
    }

    @Test
    public void testFibonacciOfFour() {
        fibonacci.setNumOfFibonacciNumbers(4);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 4 should be 3", 3, result);
    }

    @Test
    public void testFibonacciOfFive() {
        fibonacci.setNumOfFibonacciNumbers(5);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 5 should be 5", 5, result);
    }

    @Test
    public void testFibonacciOfSix() {
        fibonacci.setNumOfFibonacciNumbers(6);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 6 should be 8", 8, result);
    }

    @Test
    public void testFibonacciOfTen() {
        fibonacci.setNumOfFibonacciNumbers(10);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 10 should be 55", 55, result);
    }

    @Test
    public void testFibonacciOfTwenty() {
        fibonacci.setNumOfFibonacciNumbers(20);
        long result = fibonacci.countFibonacciNumbers();
        assertEquals("Fibonacci of 20 should be 6765", 6765, result);
    }
}