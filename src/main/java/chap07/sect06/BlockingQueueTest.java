package chap07.sect06;
public class BlockingQueueTest {
  public static void main(String[] args) throws InterruptedException {
    var queue = new java.util.concurrent.ArrayBlockingQueue<String>(2);
    java.util.stream.IntStream.range(0, 4).forEach( i -> new Thread(() -> {
      try {
        queue.put(Thread.currentThread().getName());
        System.out.print(" Put: " + Thread.currentThread().getName());
      } catch (Exception e) { e.printStackTrace(); }
    }, String.valueOf( i )).start());
    for (;;) {
      Thread.sleep(100);
      System.out.print(" Take- " + queue.take());
} } }