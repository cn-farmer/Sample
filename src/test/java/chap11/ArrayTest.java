package chap11;

public class ArrayTest {

  public static void main(String[] args) throws Exception {
    MyConstruct.class.getConstructor(null).newInstance();
    MyConstruct.class.getConstructor(new Class[0]).newInstance();

    MyConstruct.class.getConstructor(String.class).newInstance("test1");
    MyConstruct.class.getConstructor(new Class[]{String.class}).newInstance("test2");

    MyConstruct.class.getConstructor(String.class,Number.class).newInstance("test1", 1);
    MyConstruct.class.getConstructor(new Class[]{String.class, Number.class}).newInstance("test2", 2);

    print( new Object[0]);
    print( null );
  }
  
  public static void print( Object[] oo ) {
    for (Object object : oo) {
      System.out.println(object);
    }
  }
}

class MyConstruct{
  public MyConstruct(){
    System.out.println("no args");
  }

  public MyConstruct( String s ){
    System.out.println("String args" + s);
  }
  public MyConstruct( String s, Number n ){
    System.out.println("String and Number args" + s);
  }
}