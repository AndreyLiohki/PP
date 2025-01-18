import Singleton.ExpressionValidatorHandler;
import validator.ExpressionValidator;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ExpressionValidatorHandlerTest {

    @Test
    public void testGetInstance() {
        ExpressionValidator instance1 = ExpressionValidatorHandler.getInstance();
        assertNotNull("Instance should not be null", instance1);
        ExpressionValidator instance2 = ExpressionValidatorHandler.getInstance();
        assertSame("Instances should be the same", instance1, instance2);
    }
}