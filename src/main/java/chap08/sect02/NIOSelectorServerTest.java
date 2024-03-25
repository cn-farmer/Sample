package chap08.sect02;
import java.nio.ByteBuffer;
import java.nio.channels.*;
public class NIOSelectorServerTest {
  public static void main(String[] args) throws Exception {
    ServerSocketChannel ssc = ServerSocketChannel.open();
    ssc.bind(new java.net.InetSocketAddress("127.0.0.1",5000));
    ssc.configureBlocking(false);
    Selector selector = Selector.open();
    ssc.register(selector, SelectionKey.OP_ACCEPT);

    while(true) {
      selector.select();
      java.util.Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
      while (iterator.hasNext()) {
        SelectionKey selectionKey = (SelectionKey) iterator.next();
        if( selectionKey.isAcceptable()) {
          ServerSocketChannel channel = (ServerSocketChannel)selectionKey.channel();
          SocketChannel sc = channel.accept();
          sc.configureBlocking(false);
          sc.register(selector, selectionKey.OP_READ);
        }
        if( selectionKey.isReadable()) {
          SocketChannel channel = (SocketChannel)selectionKey.channel();
          ByteBuffer buffer = ByteBuffer.allocate(1024);
          channel.read(buffer);
          System.out.println(new String(buffer.array()));
          channel.write(ByteBuffer.wrap("hello client".getBytes()));
        }
      }
      iterator.remove();
    }
  }
}