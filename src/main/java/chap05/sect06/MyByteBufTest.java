package chap05.sect06;
public class MyByteBufTest {
  public static void main(String[] args) {
    MyByteBuf buffer = new MyByteBuf(8, 10);
    System.out.println("1:  " + buffer);
    buffer.writeByte('A').writeByte('B').writeByte('C').writeByte('D');
    System.out.println("2:  " + buffer);
    buffer.readByte();
    System.out.println("3:"+String.valueOf((char)buffer.readByte())+" " + buffer);
    buffer.discardReadBytes();
    System.out.println("4:  " + buffer);
    buffer.setByte(1, 'X').setByte(4, 'Y').setByte(7, 'Z');
    System.out.println("5:  " + buffer);
    System.out.println("6:"+String.valueOf((char)buffer.getByte(4))+" " + buffer);
    System.out.println("7:" + buffer.isWritable());
  }
}