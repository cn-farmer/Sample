package chap04.sect05;
public class StringGenerate {
  public static void main(String[] args) throws Exception {
    System.out.println(System.getProperties().get("file.encoding"));
    System.out.print(new String("𠀄"));

    char[] chars1 = Character.toChars(0x02_00_04);
    char[] chars2 = { 0xd840, 0xdc04 };

    System.out.print(new String(chars1));
    System.out.print(new String(chars2));
    System.out.print(new String("\uD840\uDC04"));

    byte[] bytes1 = { (byte) 0xd8, (byte) 0x40, (byte) 0xdc, (byte) 0x04 };
    System.out.print(new String(bytes1, "utf16"));
    System.out.print(new String(bytes1, "utf-16be"));
    byte[] bytes4 = { (byte) 0x40, (byte) 0xd8, (byte) 0x04, (byte) 0xdc };
    System.out.print(new String(bytes4, "utf-16le"));
    byte[] bytes5 = { (byte) 0xf0, (byte) 0xa0, (byte) 0x80, (byte) 0x84 };
    System.out.print(new String(bytes5, "utf-8"));
  }
}