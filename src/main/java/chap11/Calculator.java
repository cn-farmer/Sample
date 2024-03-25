package chap11;

public class Calculator {
  public int sum(int x, int y) {
    return x+y;
  }

  public int divide( int x, int y ) {
    if(  y == 0 ) {
     throw new IllegalArgumentException("除数不能为零!");
    }
    return x/y;
  }
}