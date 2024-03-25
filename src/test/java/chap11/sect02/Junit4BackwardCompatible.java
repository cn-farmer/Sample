package chap11.sect02;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestResult;

public class Junit4BackwardCompatible {

  public static void main(String[] args) {
    JUnit4TestAdapter adapter = new JUnit4TestAdapter(chap11.CalculatorTest.class);
    TestResult tr = new TestResult();
    adapter.run(tr);
    System.out.println("总案例数:"+tr.runCount() + " 失败:"+tr.failureCount());
  }
}