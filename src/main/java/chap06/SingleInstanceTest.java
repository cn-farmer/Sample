package chap06;
import java.util.Vector;
import java.util.concurrent.*;
public class SingleInstanceTest {
  public static void main(String[] args) throws Exception {
    SingleInstance singleInstance = new SingleInstance();
    Runnable runnable = new Runnable() {
      public void run() {
        singleInstance.biz();
      }
    };
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
    newFixedThreadPool.execute(runnable);
    newFixedThreadPool.execute(runnable);
    newFixedThreadPool.execute(runnable);
  }
}
class SingleInstance {
  Vector<String> vector = new Vector<String>();
  public void biz() {
    vector.add(Thread.currentThread().getName() + ":" + this.hashCode());
    System.out.println(vector);
  }
}