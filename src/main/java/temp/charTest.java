package temp;

public class charTest {
public static char[] chars = new char[100];
  public static void main(String[] args) {
    char c = 0xfff0;
    append(c);
    System.out.println("-------------------------");
    System.out.println(Integer.toHexString(c));
    System.out.println(Integer.toHexString(chars[0]));
    
    short s = (short) 0xfff0;
    sss(s);
    System.out.println("---------------------");
    System.out.println(s);
    char cc = (char) s;
    System.out.println(Integer.toHexString(cc));
    System.out.println(Integer.toHexString(chars[0]));

  }
  public static void write( int i ){
    System.out.println(Integer.toHexString(i));
    chars[0] = (char)i;
    write(chars);
  }
  public static void append( char c ){
    System.out.println(Integer.toHexString(c));
   write(c); 
  }
  public static void sss(short s ) {
    System.out.println(Integer.toHexString(s));
   write(s); 
  }
  public static void write( char[] cs ){
    System.out.println(Integer.toHexString(cs[0]));
  }
}