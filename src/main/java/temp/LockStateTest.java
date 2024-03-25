package temp;

import static org.mockito.Mockito.doThrow;

import java.util.concurrent.locks.ReentrantLock;

public class LockStateTest {
  private static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {

    new Thread(() -> {
      lock.lock();
      try {
        Thread.sleep(20000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
        System.out.println("lock release");
      }
    }, "tttt").start();
    
    new Thread(()->{
      lock.lock();
      try {
        Thread.sleep(20000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("get lock");
      try {
        System.out.println("locked");
      } catch (Exception e2) {

      }
      finally {
        System.out.println("lock release 2222");
      }
    }, "tttttt22222222222").start();
    
  }
}
