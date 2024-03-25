package chap11;
import chap11.Calculator;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
  public final void testSum() {
    Calculator calculator = new Calculator();
    int sum = calculator.sum(1, 2);
    assertEquals(3, sum);;
  }

  public final void testDivide() {
    Calculator calculator = new Calculator();
    int divide = calculator.divide(2, 1);
    assertEquals(divide, 2);;
  }
}
