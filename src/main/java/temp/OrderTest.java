package temp;
import java.util.concurrent.CountDownLatch;
public class OrderTest {
  static int x,y,a,b;
  public static void main(String[] args) throws InterruptedException {
    while (true) {
      x=0;y=0;a=0;b=0;
      CountDownLatch end = new CountDownLatch(2);
      new Thread(() -> {
          a = 1;
          x = b;
          end.countDown();
      }).start();
      new Thread(() -> {
          b = 1;
          y = a;
          end.countDown();
      }).start();
      end.await();
      if (x == 0 && y == 0) {
        System.out.println("x = " + x );
        System.out.println("y = " + y );
        System.out.println("a = " + a );
        System.out.println("b = " + b );
      }
    }
  }
}