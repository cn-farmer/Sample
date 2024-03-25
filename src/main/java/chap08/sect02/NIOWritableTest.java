package chap08.sect02;
import java.nio.ByteBuffer;
import java.nio.channels.*;
public class NIOWritableTest {
  public static void main(String[] args) throws Exception {
    SocketChannel sc = SocketChannel.open();
    sc.connect(new java.net.InetSocketAddress("127.0.0.1", 5000));
    sc.configureBlocking(false);
    Selector selector = Selector.open();
    sc.register(selector, SelectionKey.OP_WRITE);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 500 * 1000; i++) {
      sb.append(" - " + i);
    }
    ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes());
    while (true) {
      selector.select(1);
      java.util.Set<SelectionKey> keys = selector.selectedKeys();
      if ( !keys.isEmpty() && keys.iterator().next().isWritable()){
        if (buffer.hasRemaining()) {
          System.out.println("remaining:" + buffer.remaining());
        }
        sc.write(buffer);
      }
      keys.clear();
    }
  }
}