package chap06;
import java.util.*;
import java.util.concurrent.*;
public class SimpleCallableTest {
  public static void main(String[] args) throws Exception {
    FutureTask<Map<Integer, String>> task=new FutureTask<>(new MySimpleCallable());
    new Thread(task).start();
    Map<Integer, String> map = task.get(1000,TimeUnit.MILLISECONDS);
    System.out.println(map);
  }
}
class MySimpleCallable implements Callable<Map<Integer, String>> {
  @Override
  public Map<Integer, String> call() throws Exception {
    Map<Integer, String> map = new HashMap<Integer, String>();
    map.put(1, Thread.currentThread().getName());
    return map;
  }
}