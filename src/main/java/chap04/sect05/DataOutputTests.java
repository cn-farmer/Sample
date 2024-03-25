package chap04.sect05;
import java.io.*;
public class DataOutputTests {
  public static void main(String[] args) throws Exception {
    try (var dos = new DataOutputStream(new FileOutputStream("DOS.dat"))) {
      dos.writeChars("𠀄");
      dos.writeBytes("𠀄");
      dos.writeUTF("𠀄"); 
      dos.write("𠀄".getBytes("utf-16be"));
      dos.write("𠀄".getBytes("utf-8"));
    }
  }
}