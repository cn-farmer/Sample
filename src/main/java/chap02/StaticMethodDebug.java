package chap02;

public class StaticMethodDebug {
  static {
    String ssString  = "adf";
    System.out.println("in  static block");
  }

  
  public StaticMethodDebug() {
  }
 

  public void fun() {
    System.out.println("f1");
  }
  
  public static void staticF() {
    System.out.println("f2");
  }
}