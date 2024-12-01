import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTestNGTest {

    @Test
    public void testFactorialPositive() {
        assertEquals(Factorial.factorial(5), 120);
        assertEquals(Factorial.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.factorial(-1);
    }
}
