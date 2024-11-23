import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    @Test
    void testFactorial() {
        assertEquals(1, FactorialCalculator.factorial(0));
        assertEquals(1, FactorialCalculator.factorial(1));
        assertEquals(120, FactorialCalculator.factorial(5));
        assertEquals(720, FactorialCalculator.factorial(6));
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
    }
}
