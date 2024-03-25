package chap07.sect02;
import java.lang.invoke.*;
public class VolatileTest2 {
  public static Boolean completed = false;
  public static void main(String[] args) throws Exception {
    new Thread(() -> {
      java.util.concurrent.locks.LockSupport.parkNanos(1000 * 1000 * 1000L);
      COMPLETED.setRelease(true);
      System.out.println(Thread.currentThread().getName()+" completed -"+completed);
    }).start();
    while( !(Boolean) COMPLETED.getAcquire()) { }
    System.out.println(Thread.currentThread().getName()+" completed -"+completed);
  }
  private static final VarHandle COMPLETED;
  static {
    MethodHandles.Lookup l = MethodHandles.lookup();
    try {
      COMPLETED=l.findStaticVarHandle(VolatileTest2.class,"completed",Boolean.class);
    } catch (Exception e) {
      throw new ExceptionInInitializerError(e);
} } }