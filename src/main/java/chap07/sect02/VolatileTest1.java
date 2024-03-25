package chap07.sect02;
public class VolatileTest1 {
  public static volatile boolean volatileFlag = false;
  public static volatile boolean completed = false;
  public static void main(String[] args) throws Exception {
    new Thread(() -> {
      java.util.concurrent.locks.LockSupport.parkNanos(1000*1000*1000L);
      volatileFlag = true;
      completed = true;
      System.out.println(Thread.currentThread().getName()+" - "+completed);
    }).start();
    while (!completed) {
//      Boolean v = volatileFlag;
    }
    System.out.println( Thread.currentThread().getName()+" - "+completed);
} }