package chap05.sect05;

import java.io.FileReader;
import java.io.FileWriter;
import sun.nio.cs.UTF_8;

public class MixReaderTest {
  public static void main(String[] args) throws Exception {
    try (FileWriter fileWriter = new FileWriter("writer2.txt",new UTF_8())) {
      fileWriter.write("a©中𠀀𠀁");
    }

    for (int i = 1; i <= 7; i++) {
      char[] chars1 = new char[10];
      char[] chars2 = new char[10];
      FileReader fileReader = new FileReader("writer2.txt", new UTF_8());
      int read1 = fileReader.read(chars1, 0, i);
      int read2 = fileReader.read(chars2);
      System.out.print(new String(chars1) + "\t");
      for (int j = 0; j < read1; j++) {
        System.out.print(Integer.toHexString(chars1[j]).toUpperCase() + " - ");
      }
      for (int j = 0; j < read2; j++) {
        System.err.print(Integer.toHexString(chars2[j]).toUpperCase() + " - ");
      }
      System.err.println(new String(chars2));
    }
  }
}