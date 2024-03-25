package chap07.sect04;
public class SemaphoreTest {
  public static void main(String[] args) throws InterruptedException {
    var semaphore = new java.util.concurrent.Semaphore(1);
    for (int i = 0; i < 4; i++) {
      new Thread(() -> {
        try {
          System.out.println(Thread.currentThread().getName() + " : acquiring...");
          semaphore.acquire();
          System.out.println(Thread.currentThread().getName() + " : acquired");
          Thread.sleep((int) ( 3000));
        } catch (Exception e) {
        } finally {
          semaphore.release();
          System.out.println(Thread.currentThread().getName() + " : released");
          }
      }).start();
    }
  }
}