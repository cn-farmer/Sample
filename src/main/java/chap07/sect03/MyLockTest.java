package chap07.sect03;
public class MyLockTest {
  public static volatile Integer step = 0;
  public static Integer threadCount = 4;
  public static void main(String[] args) throws InterruptedException {
    var lock = new MyLock();
//    var lock = new java.util.concurrent.locks.ReentrantLock();
    var condition = lock.newCondition();
    for (int i = 0; i < threadCount; i++) {
      new Thread(() -> {
        int threadNo = Integer.parseInt(Thread.currentThread().getName());
        lock.lock();
        try {
          for (int countPerThread = 0; countPerThread < 3; countPerThread++) {
            while (step % threadCount != threadNo) {
              condition.await();
            }
            step++;
            System.out.print(countPerThread * threadCount + threadNo + " ");
            condition.signalAll();
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      },String.valueOf(i)).start();
} } }