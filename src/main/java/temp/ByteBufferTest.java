package temp;

import java.nio.ByteBuffer;

public class ByteBufferTest {

  public static void main(String[] args) {
    ByteBuffer source = ByteBuffer.allocate(30);
    source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
    split(source);
    source.put("w are you?\nhaha!\n".getBytes());
    split(source);
  }

  private static void split(ByteBuffer source) {
    source.flip();
    int oldLimit = source.limit();
    for (int i = 0; i < oldLimit; i++) {
      if (source.get(i) == '\n') {
        System.out.println(i);
        ByteBuffer target = ByteBuffer.allocate(i + 1 - source.position());
        // 0 ~ limit
        source.limit(i + 1);
        target.put(source); // 从source 读，向 target 写
        target.flip();
        System.out.println(new String(target.array()));
        source.limit(oldLimit);
      }
    }
    source.compact();
  }
}