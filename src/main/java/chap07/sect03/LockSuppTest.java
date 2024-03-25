package chap07.sect03;
import java.util.concurrent.locks.LockSupport;
public class LockSuppTest {
  public static Thread[] threads = new Thread[4];
  public static void main(String[] args) {
    for (int threadNo = 1; threadNo <= threads.length; threadNo++ ) {
      threads[threadNo - 1] = new LockSuppSub(threadNo );
      threads[threadNo - 1].start();
    }
    LockSupport.unpark(Thread.currentThread());
    LockSupport.parkNanos(2000*1000*1000L);
    threads[0].interrupt();
  }
}
class LockSuppSub extends Thread {
  int threadNo;
  public LockSuppSub(int threadNo) { this.threadNo = threadNo; }
  public void run() {
    for (int countPerThread = 0; countPerThread < 3; countPerThread++) {
      LockSupport.park();
      System.out.print((countPerThread * LockSuppTest.threads.length + threadNo + " "));
      LockSupport.unpark(LockSuppTest.threads[threadNo % LockSuppTest.threads.length]);
      Thread.currentThread().interrupted();
} } }