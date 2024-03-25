package chap07.sect02;
public class SyncVisibleTest {
  public static boolean completed = false;
  public static void main(String[] args) throws Exception {
    new Thread(() -> {
      java.util.concurrent.locks.LockSupport.parkNanos(1000*1000*1000);
      synchronized (SyncVisibleTest.class) {
        completed = true;
        SyncVisibleTest.class.notify();
      }
      System.out.println(Thread.currentThread().getName()+" - "+completed);
    }).start();
    long time = new java.util.Date().getTime();
    synchronized (SyncVisibleTest.class) {
      while (!completed) {
        if( new java.util.Date().getTime() > (time + 2000)) {
          SyncVisibleTest.class.wait();
        }
      }
    }
    System.out.println( Thread.currentThread().getName()+" - "+completed);
} }