package chap04.sect04;
public class OutputTest {
  public static void main(String[] args) throws Exception {
    String s = "源码阅读方法论";

    byte[] bytes = s.getBytes("iso_8859_1");
    System.out.println(new String( s.getBytes("gbk"),"iso_8859_1"));
    System.out.println(new String( s.getBytes("utf-8"),"iso_8859_1"));
    System.out.println(new String( s.getBytes("iso_8859_1"),"gbk"));
    System.out.println(new String( s.getBytes("utf-8"),"gbk"));
    System.out.println(new String( s.getBytes("gbk"),"utf-8"));
    System.out.println(new String( new String( s.getBytes("gbk"),"utf-8").getBytes("utf-8"),"gbk"));
    System.out.println(new String( new String( s.getBytes("utf-8"),"gbk").getBytes("gbk"),"utf-8"));
  }
}