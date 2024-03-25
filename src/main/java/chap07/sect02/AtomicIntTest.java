package chap07.sect02;
import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntTest {
  static Integer i = Integer.valueOf(0);
  static AtomicInteger  atomicInt = new AtomicInteger(0);
  public static void main(String[] args) throws Exception {
    for (int threads = 0; threads < 2; threads++) {
      new Thread(() -> {
        for (int i = 0; i < 50000; i++) {
          i++;
          atomicInt.incrementAndGet();
        }
      }).start();
    }
    Thread.sleep(1000);
    System.out.println("i=" + i + "  atomicInt=" + atomicInt);
  }
}