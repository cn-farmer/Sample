package chap04.sect02;
public class PrintUTF16 {
  public static void main(String[] args) throws Exception {
    String s = "𠀄";
    char[] charArray = s.toCharArray();
    String[] arr={"utf-16be","utf-16le","unicode","utf-16","UnicodeLittle"};
    for (String cs : arr) {
      System.out.print("\n" + String.format("%14s", cs) + " ");
      for (byte b : s.getBytes(cs)) {
        System.out.print(String.format("%08d", Integer.parseInt(Integer.toBinaryString(b & 0xff))));
        System.out.print("[" + String.format("%02x", b) + "]" + " ");
      }
    }
  }
}