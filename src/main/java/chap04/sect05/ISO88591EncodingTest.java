package chap04.sect05;

import sun.nio.cs.ISO_8859_1;

public class ISO88591EncodingTest {
  public static void main(String[] args) throws Exception {
    byte[] bytes = "中文".getBytes(new ISO_8859_1()); 
    System.out.println(new String(bytes));
  }
}