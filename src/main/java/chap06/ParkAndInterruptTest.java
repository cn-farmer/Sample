package chap06;

import java.util.concurrent.locks.LockSupport;

public class ParkAndInterruptTest {

  public static void main(String[] args) throws Exception {
    
    Thread thread = new Thread(()->{
      System.out.println("before park");
      LockSupport.park();
      System.out.println("after park");
    });
    thread.start();
    
    Thread.sleep(2000);
    
    LockSupport.unpark(thread);
//    System.out.println("interrupted");
  }
}
