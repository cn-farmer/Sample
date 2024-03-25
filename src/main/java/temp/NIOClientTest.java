package temp;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClientTest {
  public static void main(String[] args) throws Exception {
    SocketChannel sc = SocketChannel.open();
    sc.connect(new InetSocketAddress("localhost",5000));
    sc.configureBlocking(false);
    
    sc.write(ByteBuffer.wrap("abcdefghijklmnopqrstUVWXYZ".getBytes()));
    
    System.in.read();
  }
}
