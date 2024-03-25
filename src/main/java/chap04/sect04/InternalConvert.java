package chap04.sect04;

import java.io.FileInputStream;
import java.io.PrintStream;

public class InternalConvert {
  public static void main(String[] args) throws Exception {
    System.out.println("file.encoding:" + System.getProperty("file.encoding"));
    System.out.println("sun.stdout.encoding:" + System.getProperty("sun.stdout.encoding"));
    String path = InternalConvert.class.getResource("").getPath();
    FileInputStream fis = new FileInputStream(path + "Mix.txt");
    byte[] bytes = new byte[fis.available()];
    fis.read(bytes);
    System.out.println(new String( bytes));
    System.out.println(new String( new String(bytes,"utf-8").getBytes("gbk")));

    PrintStream printStream = new PrintStream(System.out, true, "gbk");
    printStream.println(new String(bytes));
  }
}