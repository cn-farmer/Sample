package chap04.sect01;

import sun.nio.cs.ISO_8859_2;

public class PrintISOByCharacter {
  public static void main(String[] args) {
    System.err.print("     0x0 0x1 0x2 0x3 0x4 0x5 0x6 0x7 0x8 0x9 0xA 0xB 0xC 0xD 0xE 0xF");
    for (int i = 0; i < 256; i++) {
      if (i % 16 == 0) {
        System.out.print("\n0x" + Integer.toHexString(i / 16).toUpperCase() + "0  ");
      }

      byte[] bs = { (byte) (i) };
      String iso = new String(bs, new ISO_8859_2());
      Character ch = new Character((char) i);
      if( iso.equals(ch.toString())) {
        System.out.print( "=   ");
      }
    }
  }
}