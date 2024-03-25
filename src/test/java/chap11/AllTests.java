package chap11;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

  public static Test suite() {
    TestSuite suite = new TestSuite(AllTests.class.getName());
    suite.addTestSuite(CalculatorTest.class);
    return suite;
  }
}