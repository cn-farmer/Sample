package temp;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
public class QueueTest {

  public static void main(String[] args) {
    var queue = new ArrayBlockingQueue<Integer>(1);
//     var queue = new SynchronousQueue<Integer>();
    new Thread(() -> {
      System.out.println( new Date());
      for (int i = 0; i <= 10000000; i++) {
        try {
          queue.put(i);
        } catch (InterruptedException e) { e.printStackTrace(); }
      }
    }).start();

    new Thread(() -> {
      for (;;) {
        try {
          Integer take = queue.take();
          if (take == 10000000) {
            System.out.println( new Date());
          }
        } catch (InterruptedException e) { e.printStackTrace(); }

      }
    }).start();
  }
}
