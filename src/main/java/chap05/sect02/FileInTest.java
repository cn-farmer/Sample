package chap05.sect02;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class FileInTest {
  public static void main(String[] args) throws Exception {
    FileInputStream fis = new FileInputStream("person.txt");
    fis.mark(0);
    System.out.println(new String( fis.readAllBytes()));
    System.out.println("mark suppoert:" + fis.markSupported());

    fis = new FileInputStream("person.txt");
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] bytes = new byte[5];
    int len;
    while( -1 != ( len = fis.read(bytes))){
      baos.write(bytes, 0, len);
    }
    System.out.println(new String(baos.toByteArray()));
  }
}