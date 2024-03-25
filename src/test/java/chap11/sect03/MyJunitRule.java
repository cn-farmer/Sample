package chap11.sect03;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyJunitRule {
  @Rule
  public TestRule tr1 = new TestRule() {
    public Statement apply(Statement base, Description description) {
      Statement statement = new Statement() {
        public void evaluate() throws Throwable {
          System.out.println("rule start");
          base.evaluate();
          System.out.println("rule end");
        }
      };
      return statement;
    }
  };
  @Test
  public void testRuleDemo() {
    System.out.println("test rule demo....");
    assertTrue(true);
  }
}