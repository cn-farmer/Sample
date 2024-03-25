package chap04.sect02;
public class PrintUTF32 {
  public static void main(String[] args) throws Exception {
		String s = "𠀄";
		String[] arr = {"utf-32", "utf-32be", "utf-32le", "utf-32be-bom", "utf-32le-bom"};
		for (String cs : arr) {
		  System.out.print("\n" + String.format("%14s", cs) + " ");
		  for (byte b : s.getBytes( cs )) {
			  System.out.print("["+String.format("%02x", b) +"]" + " ");
		  }
		}
  }
}