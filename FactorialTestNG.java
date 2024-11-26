import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTestNG {
    
    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1);
    }
    
    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(Factorial.calculateFactorial(5), 120);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.calculateFactorial(-1);
    }
}
