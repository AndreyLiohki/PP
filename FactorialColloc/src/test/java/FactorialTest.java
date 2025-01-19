import org.example.Factorial;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        Factorial factorial = new Factorial();
        factorial.setFactorNumber(0);
        long result = factorial.countFibonacciNumbers();
        assertEquals(1, result);
    }

    @Test
    public void testFactorialOfOne() {
        Factorial factorial = new Factorial();
        factorial.setFactorNumber(1);
        long result = factorial.countFibonacciNumbers();
        assertEquals(1, result);
    }

    @Test
    public void testFactorialOfTwo() {
        Factorial factorial = new Factorial();
        factorial.setFactorNumber(2);
        long result = factorial.countFibonacciNumbers();
        assertEquals(2, result);
    }

    @Test
    public void testFactorialOfThree() {
        Factorial factorial = new Factorial();
        factorial.setFactorNumber(3);
        long result = factorial.countFibonacciNumbers();
        assertEquals(6, result);
    }

    @Test
    public void testFactorialOfFour() {
        Factorial factorial = new Factorial();
        factorial.setFactorNumber(4);
        long result = factorial.countFibonacciNumbers();
        assertEquals(24, result);
    }

}