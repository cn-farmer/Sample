package chap08.sect01;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
public class NIOBlockClient {
  public static void main(String[] args) throws Exception {
    SocketChannel sc = SocketChannel.open();
    sc.connect(new InetSocketAddress("127.0.0.1",5000));
    sc.write( java.nio.ByteBuffer.wrap("hello server".getBytes()));
    ByteBuffer buffer = ByteBuffer.allocateDirect(100);
    int read = sc.read(buffer);
    byte[] bytes = new byte[read];
    buffer.flip().get(bytes);
    System.out.println(new String(bytes));
    System.in.read();
  }
}