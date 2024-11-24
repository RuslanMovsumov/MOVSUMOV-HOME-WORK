import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

public class FactorialTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        expectThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        });
    }
}
