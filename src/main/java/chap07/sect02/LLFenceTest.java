package chap07.sect02;
import java.lang.invoke.*;
public class LLFenceTest {
  public static Boolean completed = false;
  public static void main(String[] args) throws Exception {
    new Thread(() -> {
      java.util.concurrent.locks.LockSupport.parkNanos(1000 * 1000 * 1000L);
      COMPLETED.set(true);
      System.out.println(Thread.currentThread().getName()+" completed -"+completed);
    }).start();
    while ((Boolean) COMPLETED.get() != true) {
      boolean v = completed;
      COMPLETED.loadLoadFence();
    }
    System.out.println(Thread.currentThread().getName()+" completed -"+completed);
  }
  private static final VarHandle COMPLETED;
  static {
    MethodHandles.Lookup l = MethodHandles.lookup();
    try {
      COMPLETED=l.findStaticVarHandle(LLFenceTest.class,"completed",Boolean.class);
    } catch (Exception e) { throw new ExceptionInInitializerError(e);
} } }