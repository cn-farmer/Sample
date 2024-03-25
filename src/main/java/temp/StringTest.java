package temp;

public class StringTest {

  public static void main(String[] args) {
    char[] chars = Character.toChars(65536*2 + 4);
    String string =  "a" + new String( chars ) +"b";
    int codePointAt = string.codePointAt(2);

    System.out.println(codePointAt);
//    char charAt = string.charAt(3);
//    System.out.println(charAt);
//    String string = new String("ab𠀄".getBytes());
//    System.out.println(string.length());
//
//    string = "的说法";
//    System.out.println(string.length());
  }
}