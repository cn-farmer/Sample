package chap06;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class RunnablePoolTest {
  public static void main(String[] args) throws Exception {
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
//    newFixedThreadPool.execute(new MyThreadPool());
//    newFixedThreadPool.execute(new MyThreadPool());
//    newFixedThreadPool.execute(new MyThreadPool());
    MyThreadPool myThreadPool = new MyThreadPool();
    newFixedThreadPool.execute(myThreadPool);
    newFixedThreadPool.execute(myThreadPool);
    newFixedThreadPool.execute(myThreadPool);
  }
}

class MyThreadPool implements Runnable,Cloneable {
  Vector<String> vector = new Vector<String>();

  public void run() {
    vector.add(Thread.currentThread().getName());
    System.out.println(vector);
  }
}