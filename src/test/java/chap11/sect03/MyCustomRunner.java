package chap11.sect03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class MyCustomRunner extends Runner {
  Class<?> clazz;
  public MyCustomRunner(Class<?> clazz) throws InitializationError {
    this.clazz = clazz;
  }
  @Override
  public Description getDescription() {
    return Description.TEST_MECHANISM;
  }
  @Override
  public void run(RunNotifier notifier) {
    String cycleCount = System.getProperties().getProperty("CYCLE_COUNT");
    for (Method method : clazz.getDeclaredMethods()) {
      try {
        Constructor<?> constructor = clazz.getConstructor(null);
        Object newInstance = constructor.newInstance();
        method.invoke(newInstance, Integer.parseInt(cycleCount));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}