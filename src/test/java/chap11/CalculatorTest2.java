package chap11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.CategoryValidator;
import org.junit.validator.ValidateWith;

public class CalculatorTest2 {

  @BeforeClass
  @ValidateWith(CategoryValidator.class)
  public static void setUpBeforeClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testSum() {
//    fail("Not yet implemented");
  }

}
