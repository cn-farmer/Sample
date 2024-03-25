package chap04.sect04;
import java.io.FileInputStream;
public class MixTest {
  public static void main(String[] args) throws Exception {
    String path = MixTest.class.getResource("").getPath();
    try (FileInputStream fis = new FileInputStream(path + "Mix.txt")) {
      byte[] bytes = new byte[fis.available()];
      fis.read(bytes);
      System.out.println(new String(bytes));
    }
  }
}