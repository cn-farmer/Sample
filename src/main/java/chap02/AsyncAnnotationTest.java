  package chap02;
  import org.jetbrains.annotations.Async;
  import java.util.concurrent.Callable;
  import java.util.concurrent.FutureTask;
  public class AsyncAnnotationTest {
      public static void main(String[] args) throws Exception {
          new FutureTask<>(new MyAsyncCallable()).run();
          new Thread(new MyAsyncRunnable()).start();
      }
  }
  
  class MyAsyncCallable implements Callable{
      public Object call() throws Exception {
          System.out.println("calling...");
          return null;
      }
  }
  
  class MyAsyncRunnable implements  Runnable{
      @Async.Schedule
      public MyAsyncRunnable() {
      }
      @Async.Execute
      public void run() {
          System.out.println("running...");
      }
  }
