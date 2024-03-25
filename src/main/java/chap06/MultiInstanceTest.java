package chap06;
import java.util.Vector;
import java.util.concurrent.*;
public class MultiInstanceTest {
  public static void main(String[] args) throws Exception {
    Runnable runnable = new Runnable() {
      public void run() {
        new MultiInstance().biz();
      }
    };
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
    newFixedThreadPool.execute(runnable);
    newFixedThreadPool.execute(runnable);
    newFixedThreadPool.execute(runnable);
  }
}
class MultiInstance {
  static Vector<String> vector = new Vector<String>();
  public void biz() {
    vector.add(Thread.currentThread().getName() + ":" + this.hashCode());
    System.out.println(vector);
  }
}