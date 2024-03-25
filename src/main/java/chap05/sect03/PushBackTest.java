package chap05.sect03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.PushbackInputStream;

public class PushBackTest {
  public static void main(String[] args) throws Exception {
    PushbackInputStream pis = new PushbackInputStream(new FileInputStream("mos.txt"), 10);
    DataInputStream dis = new DataInputStream(pis);
    
    byte[] bs = new byte[2];
    int len;
    while (-1 != (len = pis.read(bs))) {
      short s = (short) ((bs[0] << 8) | bs[1]);
      pis.unread(bs);

      System.out.println( "字节数:" + s + " 文字内容:" + dis.readUTF());
    }
  }
}