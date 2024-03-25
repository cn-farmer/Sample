package chap04.sect04;

import java.io.FileReader;

public class CommonTest {
  public static void main(String[] args) throws Exception {
    String path = FileEncodingTest.class.getResource("").getPath();
    try( FileReader reader = new FileReader(path +"Common.txt")){
      char[] chars = new char[10];
      reader.read(chars);
      System.out.println(chars);
    }
  }
}