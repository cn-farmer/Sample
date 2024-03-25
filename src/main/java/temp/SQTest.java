package temp;

import java.util.concurrent.SynchronousQueue;

public class SQTest {

  public static void main(String[] args) throws InterruptedException {
    var queue = new SynchronousQueue<Integer>();

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        try {
          queue.put(1);
          System.out.println("queue add");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    System.out.println("main");
    queue.take();
  }
}