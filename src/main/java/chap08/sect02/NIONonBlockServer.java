package chap08.sect02;
import java.nio.ByteBuffer;
import java.nio.channels.*;
public class NIONonBlockServer {
  public static void main(String[] args) throws Exception {
    ServerSocketChannel ssc = ServerSocketChannel.open();
    ssc.configureBlocking(false);
    ssc.bind(new java.net.InetSocketAddress(5000)); 
    SocketChannel sc;
    while(( sc = ssc.accept()) == null) {
      System.out.println("accepting:" + new java.util.Date());
      Thread.sleep(2000);
    }
    sc.configureBlocking(false);

    ByteBuffer buffer = ByteBuffer.allocate(100);
    while ( true ) {
      if( sc.read(buffer) > 0 ) {
        System.err.println(new String(buffer.array()));
        sc.write(ByteBuffer.wrap("hello client".getBytes()));
      }
      System.out.println( "reading:" + new java.util.Date());
      Thread.sleep(2000);
    }
  }
}