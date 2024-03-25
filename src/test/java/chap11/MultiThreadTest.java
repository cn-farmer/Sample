package chap11;

import junit.extensions.ActiveTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class MultiThreadTest {

  public static Test suite() {
    TestSuite suite = new ActiveTestSuite();
    suite.addTestSuite(CalculatorTest.class);
//    suite.addTestSuite(Junit4CalculatorTest.class);
      
    return suite;
  }
}
