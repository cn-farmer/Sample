package chap04.sect02;
public class PrintUTF8 {
  public static void main(String[] args) throws Exception {
    String[] arr = { "#", "Ą", "丂", "𠀄" };
    for (String str : arr) {
      System.out.print(  Integer.toBinaryString(str.codePointAt(0)));
      System.out.print( String.format("[0x%x", str.codePointAt(0)) + "]\t - ");
      for (byte b : str.getBytes("UTF-8")) {
        System.out.print(String.format("%08d", Integer.parseInt(Integer.toBinaryString(b & 0xff))));
        System.out.print("[" + String.format("%02x", b) + "]" + " ");
      }
      System.out.println("");
    }
  }
}