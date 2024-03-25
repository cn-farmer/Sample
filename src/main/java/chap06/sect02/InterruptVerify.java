package chap06.sect02;
import java.util.concurrent.locks.LockSupport;
public class InterruptVerify {
  public static void main(String[] args) throws Exception {
     new Thread(() -> {
        synchronized (InterruptVerify.class) {
          LockSupport.parkNanos(5000_000_000L);
          System.out.println("t1 finished");
    } } ).start();
    Thread t2 = new Thread(() ->{
        synchronized (InterruptVerify.class) {
          try { 
            System.out.println(Thread.currentThread().isInterrupted());
            InterruptVerify.class.wait(); 
          } catch (Exception e) { e.printStackTrace(); } 
          System.out.println("t2 finished");
        } } );
    t2.start();
    Thread.sleep(200);
    t2.interrupt();
} }