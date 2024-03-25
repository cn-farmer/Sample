package chap05.sect03;
import java.io.*;

public class PrimitiveInTest {
  public static void main(String[] args) throws Exception {
    var dis = new DataInputStream(new FileInputStream("primitive.txt"));
    System.out.println( 
        " Name:" +dis.readUTF() +
        " Age:" + dis.readInt() +
        " Married:"+ dis.readBoolean());
    dis.close();
  }
}