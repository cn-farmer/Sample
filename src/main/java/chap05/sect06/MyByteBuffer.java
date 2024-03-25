package chap05.sect06;
public class MyByteBuffer {
  int mark = -1, position = 0, limit, capacity;
  byte[] hb = null;
  public static MyByteBuffer allocate(int capacity) {
    MyByteBuffer myBuffer = new MyByteBuffer();
    myBuffer.hb = new byte[capacity];
    myBuffer.limit = myBuffer.capacity = capacity;
    return myBuffer;
  }
  public byte get() {
    if (position >= limit) {  throw new IndexOutOfBoundsException(); }
    return hb[position++];
  }
  public MyByteBuffer put(byte x) {
    if (position >= limit) {  throw new IndexOutOfBoundsException(); }
    hb[position++] = x;
    return this;
  }
  public void flip() {
    limit = position;
    position = 0;
    mark = -1;
  }
  public void compact() {
    System.arraycopy(hb, position, hb, 0, limit - position);
    position = limit - position;
    limit = capacity;
  }
  public void rewind() {
    position = 0;
    mark = -1;
  }
  public String toString() {
    char[] cc = new String(hb, new sun.nio.cs.UTF_8()).toCharArray();
    return java.util.Arrays.toString(cc)+" p="+position+" l="+limit+" c="+capacity;
} }