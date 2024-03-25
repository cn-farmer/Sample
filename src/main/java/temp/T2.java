package temp;

import java.util.concurrent.locks.LockSupport;

public class T2 {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        LockSupport.park();
      }
    });
    
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        LockSupport.parkNanos(4000_000_000L);
        System.out.println("park nanos");
      }
    });
    
    t1.start();
    t2.start();
    Thread.sleep(1000);

    System.out.println(t1.getState());
    System.out.println(t2.getState());

  }
}