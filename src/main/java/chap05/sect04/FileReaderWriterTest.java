package chap05.sect04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import sun.nio.cs.UTF_8;

public class FileReaderWriterTest {
  public static void main(String[] args) throws Exception {
    try (FileWriter fileWriter = new FileWriter("writer.txt")) {
      fileWriter.write("第一行测试write()方法");
      fileWriter.append("\n第二行测试append()方法").append("\n第三行测试append()方法连续输出");
    }

    try (BufferedReader br = new BufferedReader(new FileReader("writer.txt", new UTF_8()))) {
      String str;
      while (null != (str = br.readLine())) {
        System.out.println(str);
      }
    }
  }
}