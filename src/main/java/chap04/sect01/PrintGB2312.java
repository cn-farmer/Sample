package chap04.sect01;

public class PrintGB2312 {
  public static void main(String[] args) throws Exception {

    for (int i = 0x80; i <= 0xff; i++) {
      System.out.print("\n0x" + Integer.toHexString(i).toUpperCase() + " ");
      for (int j = 0x80; j <= 0xff; j++) {
        byte[] bs = { (byte) i, (byte) j };
        String gb2312 = new String(bs, "GB2312");
        System.out.print(gb2312);
      }
    }
  }
}