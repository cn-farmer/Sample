package temp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyByteBuffer {
  public static void main(String[] args) throws IOException {
//    Files.newBufferedWriter(Paths.get("d:/aa.txt"));

    ByteBuffer buffer = ByteBuffer.wrap("abcdefg".getBytes());
    System.out.println(new String((byte[]) buffer.array()));
    System.out.println(buffer);

    System.out.println((char)buffer.get());
    System.out.println(buffer);
    buffer.put((byte)'B');
    System.out.println(buffer);
    buffer.put((byte)'B');
    System.out.println(buffer);
    System.out.println(new String((byte[]) buffer.array()));
    System.out.println((char)buffer.get());
    System.out.println(buffer);
    buffer.rewind();
    System.out.println(buffer);
  }
}