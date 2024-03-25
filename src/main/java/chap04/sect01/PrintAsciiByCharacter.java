package chap04.sect01;

public class PrintAsciiByCharacter {
  public static void main(String[] args) {

    System.err.print("     0x0 0x1 0x2 0x3 0x4 0x5 0x6 0x7 0x8 0x9 0xA 0xB 0xC 0xD 0xE 0xF");
    for (int i = 0; i < 8; i++) {
      System.out.print("\n0x" + Integer.toHexString(i).toUpperCase() + "0 ");
      for (int j = 0; j < 16; j++) {

        Character ascii = new Character((char) (i * 16 + j));
        if (Character.isISOControl(ascii)) {
          ascii = '☺'; // /t/b/n/f/r
        }

        System.out.print(" " + ascii + "  ");
      }
    }
  }
}