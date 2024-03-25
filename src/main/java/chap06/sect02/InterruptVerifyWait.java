package chap06.sect02;
import java.util.concurrent.locks.LockSupport;
public class InterruptVerifyWait {
  public static void main(String[] args) throws Exception {
    Thread t1 = new Thread(()-> {
        synchronized (InterruptVerifyWait.class) {
          try {
            InterruptVerifyWait.class.wait(); 
          } catch (Exception e) { e.printStackTrace(); }
          System.out.println("t1 finished");
    } } );
    t1.start();
    new Thread(()-> {
        synchronized (InterruptVerifyWait.class) {
          LockSupport.parkNanos(5000_000_000L);
          System.out.println("t2 finished");
    }}).start();
    Thread.sleep(1000);
    t1.interrupt();
} }