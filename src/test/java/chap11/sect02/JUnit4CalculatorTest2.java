package chap11.sect02;
import static org.junit.Assert.*;
import org.junit.Test;

import chap11.Calculator;
public class JUnit4CalculatorTest2 {
  @Test
  public void testSum() {
    Calculator calculator = new Calculator();
    int sum = calculator.sum(1, 2);
    assertEquals(3, sum);
  }
}