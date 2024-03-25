package temp;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
public class ByteTest {
  public static void main(String[] args) {
    byte[] bs = {(byte)0xff,(byte)0xfe,(byte)0x40, (byte)0xd8, (byte)0x04, (byte)0xdc};
    ByteBuffer wrap = ByteBuffer.wrap(bs);
    String string = Charset.forName("UTF-16").decode(wrap).toString();
    System.out.println(string);
  }
}