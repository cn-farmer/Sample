package chap05.sect02;
import java.io.FileInputStream;
public class MyInStreamTest {
  public static void main(String[] args) throws Exception {
    FileInputStream fis = new FileInputStream("person.txt");
    byte[] readAllBytes = fis.readAllBytes();
    MyInStream mbis = new MyInStream(readAllBytes);
    String readBySplit;
    while (null != (readBySplit = mbis.readBySplit('|'))) {
      System.out.print(readBySplit + "\t");
    }
  }
}