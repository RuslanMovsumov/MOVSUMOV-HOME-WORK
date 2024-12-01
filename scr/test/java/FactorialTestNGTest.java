import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTestNGTest {

    @Test
    public void testFactorialPositive() {
        assertEquals(FactorialCalculator.factorial(5), 120);
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.factorial(-1);
    }
}
