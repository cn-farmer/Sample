package chap06;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public abstract class ThreadPoolApp<T, R> {
  private AtomicInteger curr = new AtomicInteger(0);
  private static AtomicInteger total = new AtomicInteger(0);
  protected abstract R bizCall(T obj);
  public List<R> poolExec(List<T> bizList, int ths) throws Exception {
    ExecutorService service = null;
    List<R> list = new ArrayList<>();
    if ( bizList.size() == 1 ) {
      R bizCall = bizCall(bizList.get(0));
      list.add(bizCall);
    } else {
       ths = ( bizList.size() < ths ) ?  bizList.size() :ths ; 
      try {
        service = Executors.newFixedThreadPool( ths );
        System.out.println("c:" + curr.addAndGet(ths) + "t:" + total.addAndGet(ths));
        List<Future<R>> futureList = new ArrayList<>();
        for (final T object : bizList) {
          Future<R> future = service.submit(new Callable<R>() {
            public R call() throws Exception { 
              return bizCall(object); 
            }
          });
          futureList.add(future);
        }
        for (Future<R> future : futureList) { 
          list.add(future.get()); 
        }
      } catch (Exception e) {
        System.out.println("线城池调用失败" + e.getMessage());
      } finally {
        if (service != null) { service.shutdown(); }
        System.out.println("c:" + curr.addAndGet(-1 * ths) + "t:" + total.addAndGet(-1 * ths));
    } }
    return list;
} }