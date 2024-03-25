package chap06;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
public final class ThreadFactoryTest {
  public static void main(String[] args) {
    ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
    defaultThreadFactory.newThread(() -> {
      System.out.println(Thread.currentThread().getName());
    }).start();
  }
}
