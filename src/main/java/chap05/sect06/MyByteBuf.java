package chap05.sect06;
public class MyByteBuf {
  byte[] array; int rPos = 0, wPos = 0, capacity;
  public MyByteBuf(int initialCapacity, int maxCapacity) {
    this.array = new byte[initialCapacity];
    this.capacity = maxCapacity;
  }
  public byte readByte() {
    if (rPos>wPos) {  throw new IndexOutOfBoundsException(); }
    return array[rPos++];
  }
  public MyByteBuf writeByte(int value) {
    if (wPos>capacity) {  throw new IndexOutOfBoundsException(); }
    array[wPos++] = (byte) value;
    return this;
  }
  public byte getByte(int index) { return array[index]; }
  public MyByteBuf setByte(int index, int value) {
    array[index] = (byte) value;
    return this;
  }
  public boolean isReadable() { return wPos > rPos; }
  public boolean isWritable() { return capacity > wPos; }
  public void clear() { rPos = wPos = 0; }
  public void discardReadBytes() {
    if (rPos != wPos) {
      System.arraycopy(array, rPos, array, 0, wPos - rPos);
      wPos -= rPos;
      rPos = 0;
    }
  }
  public String toString() {
    char[] cc = new String(array, new sun.nio.cs.UTF_8()).toCharArray();
    return java.util.Arrays.toString(cc) + " rPos="+rPos+" wPos="+wPos+" c="+capacity;
  }
}