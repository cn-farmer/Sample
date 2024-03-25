package chap04.sect02;
public class PrintUnicode {
  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 17; i++) {
      System.out.println("plane: " + i);
      for (int j = 0; j < 256; j++) {
        System.out.print("0x" + Integer.toHexString(j) + "-");
        for (int k = 0; k < 256; k++) {
          char[] chars = Character.toChars(i * 256 * 256 + j * 256 + k);
          if (chars[0] != '\n' && chars[0] != '\r') {
            System.out.print(chars);
          }
        }
        System.out.println("");
      }
    }
  }
}