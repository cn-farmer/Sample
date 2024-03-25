package chap05.sect06;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
public class NIOTest {
  public static void main(String[] args) throws Exception {
    try (FileChannel outChannel = new FileOutputStream("nio.txt").getChannel()) {
      outChannel.write( java.nio.ByteBuffer.wrap("ABC".getBytes()));
    }
    try (FileChannel rwChannel = new RandomAccessFile("nio.txt", "rw").getChannel()) {
      rwChannel.position(2).write( StandardCharsets.US_ASCII.encode("XYZ"));
      var buffer = java.nio.ByteBuffer.allocate(6);
      rwChannel.position(0).read(buffer);
       char[] ca = new String( buffer.array(), StandardCharsets.US_ASCII).toCharArray();
      System.out.println( java.util.Arrays.toString(ca)+" -"+buffer);
    }
  }
}