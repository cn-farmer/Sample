package chap11;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

public class OneTimeTest {

  public static Test suite() {
    TestSetup testSetup = new TestSetup( new CalculatorTest()) {
      @Override
      protected void setUp() throws Exception {
        System.out.println("setup");
      }

      @Override
      protected void tearDown() throws Exception {
        System.out.println("tear down");
      }
    };

    return testSetup;
  }

}
