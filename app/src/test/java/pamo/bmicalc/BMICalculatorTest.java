package pamo.bmicalc;
import static org.junit.Assert.*;
import org.junit.Test;

public class BMICalculatorTest {

    @Test
    public void testCorrectBMI() {
        String result = BMICalculator.calculate(70f, 175f);
        assertTrue(result.contains("Twoje BMI:"));
        assertTrue(result.contains("Prawidłowa masa"));
    }

    @Test
    public void testZeroHeight() {
        String result = BMICalculator.calculate(70f, 0f);
        assertEquals("Waga i wzrost muszą być większe od zera!", result);
    }

    @Test
    public void testObesity() {
        String result = BMICalculator.calculate(140f, 165f);
        assertTrue(result.contains("Otyłość III stopnia"));
    }
}