package chap04.sect05;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class WriteBytesTest {
  public static void main(String[] args) throws IOException {
    String s = "你好,JAVA";
//    String string2 = "𠀄,JAVA";
//    int length = s.length();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeBytes(s);
//    dos.writeChars(s);

    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    DataInputStream dis = new DataInputStream(bais);
    byte[] readAllBytes = bais.readAllBytes();

//    char[] cs = new char[length];
//    for( int i = 0; i < length; i++ ) {
//      cs[i] = dis.readChar();
//    }
//    System.out.println(new String(cs));
   System.out.println(new String( readAllBytes ));
  }
}