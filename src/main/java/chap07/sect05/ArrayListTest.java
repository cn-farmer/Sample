package chap07.sect05;
import java.util.ArrayList;
public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(1);
    Runnable runnable = () -> {
      for (int i = 0; i < 100000000; i++ ) {
        list.add(1);
      }
      System.out.println(Thread.currentThread().getName()+ " end!");
    };
    new Thread(runnable).start();
    new Thread(runnable).start();
  }
}