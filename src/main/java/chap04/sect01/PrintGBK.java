package chap04.sect01;

import sun.nio.cs.GBK;

public class PrintGBK {
  public static void main(String[] args) throws Exception {
    for (int i = 0x80; i <= 0xff; i++) {
      System.out.print("\n0x" + Integer.toHexString(i) + "00 ");
      for (int j = 0x80; j <= 0xff; j++) {
        byte[] b = { (byte) i, (byte) j };
        String s = new String( b,  new GBK());
        s = s.replaceAll( "[\t\b\n\f\r]", "☺");
        System.out.print(s);
      }
    }
  }
}