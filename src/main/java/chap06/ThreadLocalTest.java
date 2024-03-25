package chap06;
import java.util.*;
import java.util.concurrent.*;
public class ThreadLocalTest {
  public static ThreadLocal<List<String>> myLocal = new InheritableThreadLocal<>();
//  public static ThreadLocal<List<String>> myLocal = new ThreadLocal<>();
  public static void main(String[] args) throws InterruptedException {
    myLocal.set(new Vector<>());
    List<String> list = myLocal.get();
    list.add(Thread.currentThread().getName());
    System.out.println(myLocal.get());
    new Thread(new LocalRunnable()).start();
    new Thread(new LocalRunnable()).start();
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
    newFixedThreadPool.execute(new LocalRunnable());
    newFixedThreadPool.execute(new LocalRunnable());
  }
}
class LocalRunnable implements Runnable {
  public void run() {
    if (ThreadLocalTest.myLocal.get() == null) {
      ThreadLocalTest.myLocal.set(new Vector<>());
    }
    List<String> list = ThreadLocalTest.myLocal.get();
    list.add(Thread.currentThread().getName());
    System.out.println(list);
  }
}