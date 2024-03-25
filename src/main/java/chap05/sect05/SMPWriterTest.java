package chap05.sect05;

import java.io.FileWriter;

import sun.nio.cs.UTF_8;

public class SMPWriterTest {
  public static void main(String[] args) throws Exception {
    String str = "𠀁";
    System.out.println("字符串长度:" + str.length());
    System.out.println("码点数:" + str.codePointCount(0, str.length()));
    char[] charArray = str.toCharArray();
    FileWriter fileWriter = new FileWriter("smpwriter.txt", new UTF_8());
    fileWriter.write(charArray[0]);
    fileWriter.write(0);
    fileWriter.write(str, 0, 1);
    fileWriter.write(0);
    fileWriter.write(str, 0, 2);
    fileWriter.close();
  }
}