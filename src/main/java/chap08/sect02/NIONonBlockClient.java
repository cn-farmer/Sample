package chap08.sect02;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIONonBlockClient {
  public static void main(String[] args) throws Exception {
    SocketChannel sc = SocketChannel.open();
    var inetSocketAddress = new java.net.InetSocketAddress("127.0.0.1", 5000);
    sc.configureBlocking(false);
    boolean connect = sc.connect(inetSocketAddress);
    while( !sc.finishConnect()) {
      System.out.println( "connecting: " + new java.util.Date());
      Thread.currentThread().sleep(1000);
    }
    
    sc.write(ByteBuffer.wrap("hello server".getBytes()));
    ByteBuffer buffer = ByteBuffer.allocate(100);
    while( sc.read(buffer) <= 0 ) {
      System.out.println( "reading:" + new java.util.Date());
      Thread.sleep(3000);
    }
    System.err.println(new String(buffer.array()));
    System.in.read();
  }
}
