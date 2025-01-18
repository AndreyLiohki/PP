import objects.ExpressionEvaluationResult;
import org.junit.Before;
import org.junit.Test;
import processor.ExpressionProcessor;
import static org.junit.Assert.assertEquals;

public class ExpressionProcessorTest {
    private ExpressionProcessor processor;

    @Before
    public void setUp() {
        processor = new ExpressionProcessor();
    }

    @Test
    public void testSimpleAddition() {
        String expression = "3 + 5";
        ExpressionEvaluationResult result = processor.evaluate(expression);
        String expected = "Result of evaluating arithmetic expression using Stack 8.0\n" +
                "Result of evaluating arithmetic expression using Regular Expression 8.0\n" +
                "Result of evaluating arithmetic expression using Inner Library 8.0\n\n";
        assertEquals(expected, result.getResult());
    }

    @Test
    public void testSimpleMultiplication() {
        String expression = "3 * 5";
        ExpressionEvaluationResult result = processor.evaluate(expression);
        String expected = "Result of evaluating arithmetic expression using Stack 15.0\n" +
                "Result of evaluating arithmetic expression using Regular Expression 15.0\n" +
                "Result of evaluating arithmetic expression using Inner Library 15.0\n\n";
        assertEquals(expected, result.getResult());
    }

    @Test
    public void testSimpleDivizion() {
        String expression = "15 / 5";
        ExpressionEvaluationResult result = processor.evaluate(expression);
        String expected = "Result of evaluating arithmetic expression using Stack 3.0\n" +
                "Result of evaluating arithmetic expression using Regular Expression 3.0\n" +
                "Result of evaluating arithmetic expression using Inner Library 3.0\n\n";
        assertEquals(expected, result.getResult());
    }

    @Test
    public void testSimpleSubstraction() {
        String expression = "3 - 5";
        ExpressionEvaluationResult result = processor.evaluate(expression);
        String expected = "Result of evaluating arithmetic expression using Stack -2.0\n" +
                "Result of evaluating arithmetic expression using Regular Expression -2.0\n" +
                "Result of evaluating arithmetic expression using Inner Library -2.0\n\n";
        assertEquals(expected, result.getResult());
    }

    @Test
    public void testComplexExpression() {
        String expression = "2 + 3 * (4 - 1)";
        ExpressionEvaluationResult result = processor.evaluate(expression);
        String expected = "Result of evaluating arithmetic expression using Stack 11.0\n" +
                "Result of evaluating arithmetic expression using Regular Expression 11.0\n" +
                "Result of evaluating arithmetic expression using Inner Library 11.0\n\n";
        assertEquals(expected, result.getResult());
    }

    @Test
    public void testComplexExpression2() {
        String expression = "2^3 - 4-2+1 * (3-(4+1))-8/7";
        ExpressionEvaluationResult result = processor.evaluate(expression);
        String expected = "Result of evaluating arithmetic expression using Stack -1.1428571428571428\n" +
                "Result of evaluating arithmetic expression using Regular Expression -1.1428571428571428\n" +
                "Result of evaluating arithmetic expression using Inner Library -1.1428571428571428\n\n";
        assertEquals(expected, result.getResult());
    }

}