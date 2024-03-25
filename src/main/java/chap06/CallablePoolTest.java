package chap06;
import java.util.*;
import java.util.concurrent.*;
public class CallablePoolTest {
  public static void main(String[] args) throws Exception {
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
    Future<List<String>> submit1 = newFixedThreadPool.submit(new CallablePool());
    System.out.println(submit1.get());
     Future<List<String>> submit2 = newFixedThreadPool.submit(new CallablePool());
    System.out.println(submit2.get());
  }
}
class CallablePool implements Callable<List<String>> {
  public List<String> call() throws Exception {
     List<String> list = new ArrayList<>();
     list.add( Thread.currentThread().getName() + " " + this.hashCode());
    return list;
} }