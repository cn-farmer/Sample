package chap04.sect04;
import java.io.FileInputStream;
public class FileEncodingTest {
  public static void main(String[] args) throws Exception {
    String path = FileEncodingTest.class.getResource("").getPath();
    try (FileInputStream fis = new FileInputStream(path + "China.txt")) {
      byte[] bytes = new byte[fis.available()];
      fis.read(bytes);
      System.out.println(new String(bytes));
    }
  }
}