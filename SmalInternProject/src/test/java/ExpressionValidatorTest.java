import org.junit.Before;
import org.junit.Test;
import validator.ExpressionValidator;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExpressionValidatorTest {
    private ExpressionValidator validator;

    @Before
    public void setUp() {
        validator = new ExpressionValidator();
    }

    @Test
    public void testValidSimpleExpression() {
        String expression = "3 + 5";
        assertTrue(validator.isValidExpression(expression));
    }

    @Test
    public void testValidExpressionWithParentheses() {
        String expression = "(3 + 5) * 2";
        assertTrue(validator.isValidExpression(expression));
    }

    @Test
    public void testInvalidExpressionUnmatchedParentheses() {
        String expression = "(3 + 5 * 2";
        assertFalse(validator.isValidExpression(expression));
    }

    @Test
    public void testInvalidExpressionConsecutiveOperators() {
        String expression = "3 + * 5";
        assertFalse(validator.isValidExpression(expression));
    }

    @Test
    public void testInvalidExpressionTrailingOperator() {
        String expression = "3 + 5 - ";
        assertFalse(validator.isValidExpression(expression));
    }

    @Test
    public void testInvalidExpressionDividingByZero() {
        String expression = "3 / 0";
        assertFalse(validator.isValidExpression(expression));
    }
}
