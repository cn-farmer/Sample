package chap07.sect01;
public class NotifyAllTest {
  public static Integer step = 0, threads = 4;
  public static void main(String[] args) throws InterruptedException {
    for (int threadNo = 0; threadNo < threads; threadNo++) {
      new Thread(new WaitAndNotify(threadNo)).start();
} } }
class WaitAndNotify implements Runnable {
  int threadNo;
  public WaitAndNotify(int threadNo) { this.threadNo = threadNo; }
  public void run() {
    for (int i = 0; i < 5; i++) {
      synchronized (NotifyAllTest.class) {
        while (NotifyAllTest.step % NotifyAllTest.threads != threadNo) {
          try {
            NotifyAllTest.class.wait();
          } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.print(i * NotifyAllTest.threads + threadNo );
        NotifyAllTest.step++;
        NotifyAllTest.class.notifyAll();
} } } }