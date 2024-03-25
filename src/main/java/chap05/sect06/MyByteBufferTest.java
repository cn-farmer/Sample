package chap05.sect06;
public class MyByteBufferTest {
  public static void main(String[] args) {
    MyByteBuffer buffer = MyByteBuffer.allocate(6);
    buffer.put((byte) 'A').put((byte) 'B').put((byte)0x43);
    System.out.println("init:   " + buffer);
    buffer.flip();
    System.out.println("flip: "+String.valueOf((char)buffer.get()) + " "+buffer);
    buffer.rewind();
    System.out.println("rewind: " + buffer);
    buffer.get();
    System.out.println("get:    " + buffer);
    buffer.compact();
    System.out.println("compact:" + buffer);
    System.out.println("end:    " + buffer.put((byte) 'X').put((byte) 'Y'));
  }
}