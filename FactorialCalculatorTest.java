import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorial() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
        Assert.assertEquals(FactorialCalculator.factorial(1), 1);
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
        Assert.assertEquals(FactorialCalculator.factorial(6), 720);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.factorial(-1);
    }
}
