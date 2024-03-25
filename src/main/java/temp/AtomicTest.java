package temp;
public class AtomicTest {
  public static long l = 0;
  public static void main(String[] args) {
    new Thread(() -> {
      while (true)
        l = 1;
    }).start();

    new Thread(() -> {
      while (true)
        l = -1;
    }).start();

    long ll = 0;
    ll = l;
    while (true) {
      if (ll != 1 && ll != -1)
        break;
    }
    System.out.println(ll);
  }
}