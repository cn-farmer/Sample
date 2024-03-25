package chap05.sect02;

import java.io.FileOutputStream;

public class FileOutTest {
  public static void main(String[] args) throws Exception {
  Person person = new Person("张三", 1, true);
  FileOutputStream fos = new FileOutputStream ("person.txt");
  fos.write(person.toString().getBytes());
  fos.close();
  }
}