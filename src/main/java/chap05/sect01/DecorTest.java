package chap05.sect01;

public class DecorTest {
  public static void main(String[] args) {
    IOutput o= new StrOutput("hello world");
    System.out.println("1:" + o.getAll());

    o = new UpperDecor(new StrOutput("hello world"));
    System.out.println("2:" + o.getAll());

    o = new UpperDecor(new LineDecor( new ReverseDecor( new StrOutput("hello world"))));
    System.out.println("3:" + o.getAll());

    String[] arr = { "hello", "world"};
    o = new LineDecor( new UpperDecor(new ArrayOutput( arr )));
    System.out.println("4:" + o.getAll());
  }
}