package chap08.sect01;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOBlockServer {
  public static void main(String[] args) throws Exception {
    ServerSocketChannel ssc = ServerSocketChannel.open();
    ssc.bind(new InetSocketAddress(5000));
    SocketChannel sc = ssc.accept();
    ByteBuffer buffer = ByteBuffer.allocate(100);
    sc.read(buffer);
    System.out.println(new String(buffer.array()));
    sc.write(ByteBuffer.wrap("hello client".getBytes()));
    System.in.read();
  }
}