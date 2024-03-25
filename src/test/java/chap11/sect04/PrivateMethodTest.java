package chap11.sect04;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import chap11.EmailValidator;

public class PrivateMethodTest {
  static PrintStream systemPrintOut;
  static ByteArrayOutputStream baos = new ByteArrayOutputStream();
  @ClassRule
  public static TestRule object = new TestRule() {
    public Statement apply(Statement base, Description description) {
      Statement statement = new Statement() {
        public void evaluate() throws Throwable {
          systemPrintOut = System.out;
          System.setOut(new PrintStream(baos));
          base.evaluate();
          System.setOut(systemPrintOut);
        }
      };
      return statement;
    }
  };

  @Test
  public void tetPrivateMethod() throws Exception {
    Class<?> forName = Class.forName(EmailValidator.class.getName());
    Method declaredMethod = forName.getDeclaredMethod("isValidEmailPrivate", String.class);
    declaredMethod.setAccessible(true);
    Object newInstance = forName.newInstance();
    Object invoke = declaredMethod.invoke(newInstance, "");

    systemPrintOut.println("ssssssssssssssss-" + baos.toString());
    if (invoke instanceof Boolean) {
      assertEquals(invoke, true);
    }
  }
}