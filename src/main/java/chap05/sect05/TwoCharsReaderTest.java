package chap05.sect05;

import java.io.FileReader;
import java.io.FileWriter;

import sun.nio.cs.UTF_8;

public class TwoCharsReaderTest {
  public static void main(String[] args) throws Exception {
    try (FileWriter fileWriter = new FileWriter("writer3.txt", new UTF_8())) {
      fileWriter.write("a©中𠀀𠀁");
    }

    for (int i = 0; i < 7; i++) {
      char[] chars = new char[2];
      FileReader fileReader = new FileReader("writer3.txt", new UTF_8());
      fileReader.skip(i);
      int read = fileReader.read(chars);
      for( int j = 0; j < read; j++ ) {
        System.out.print(Integer.toHexString(chars[j]).toUpperCase() + " \t ");
      }
      System.out.println("=>\t" + new String(chars, 0, read));
    }
  }
}