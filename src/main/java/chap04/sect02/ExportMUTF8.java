package chap04.sect02;
import java.io.*;
public class ExportMUTF8 {
  public static void main(String[] args) throws Exception {
	  String s1 = "丂";
		String s2 =  "𠀄";
		var dos = new DataOutputStream(new FileOutputStream("mutf8.dat"));
		dos.writeUTF(s1);
		dos.writeUTF(s2);
		dos.close();
  }
}