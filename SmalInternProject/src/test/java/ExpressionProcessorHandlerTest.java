import Singleton.ExpressionProcessorHandler;
import processor.ExpressionProcessor;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ExpressionProcessorHandlerTest {

    @Test
    public void testGetInstance() {
        ExpressionProcessor instance1 = ExpressionProcessorHandler.getInstance();
        assertNotNull("Instance should not be null", instance1);

        ExpressionProcessor instance2 = ExpressionProcessorHandler.getInstance();
        assertSame("Instances should be the same", instance1, instance2);
    }
}