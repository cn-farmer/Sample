package chap04.sect01;

import sun.nio.cs.US_ASCII;

public class PrintAsciiByString {
  public static void main(String[] args) {
    
    System.err.print("     0x0 0x1 0x2 0x3 0x4 0x5 0x6 0x7 0x8 0x9 0xA 0xB 0xC 0xD 0xE 0xF");
    for (byte i = 0; i>= 0 && i < 128; i++) {
      if( i % 16 == 0) {
        System.out.print( "\n0x" + Integer.toHexString( i/16 ).toUpperCase() + "0 ");
      }

      String ascii = new String(new byte[] { i }, new US_ASCII());
			ascii = ascii.replaceAll( "[\t\n\r]", "☺");

      System.out.print( " " + ascii + "  ");
    }
  }
}