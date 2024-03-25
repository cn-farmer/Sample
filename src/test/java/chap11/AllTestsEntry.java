package chap11;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTestsEntry extends TestCase {

  public static Test suite() {
    TestSuite suite = new TestSuite(AllTestsEntry.class.getName());
    suite.addTest(AllTests.suite());
    suite.addTestSuite(CalculatorTest.class);
    return suite;
  }
}