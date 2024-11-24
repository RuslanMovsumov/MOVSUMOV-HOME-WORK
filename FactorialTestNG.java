import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculateFactorial(0), 1, "Факториал нуля должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.calculateFactorial(5), 120, "Факториал 5 должен быть 120");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(Factorial.calculateFactorial(10), 3628800, "Факториал 10 должен быть 3628800");
    }
    
    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        }, "Факториал отрицательного числа должен выбрасывать IllegalArgumentException");
    }
}
