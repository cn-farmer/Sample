package temp;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NIOTest {
  public static void main(String[] args) throws Exception {
    ServerSocketChannel ssc = ServerSocketChannel.open();
    SocketChannel sc = ssc.bind(new InetSocketAddress(5000)).accept();
    sc.configureBlocking(false);
    Selector selector = Selector.open();
    sc.register(selector, SelectionKey.OP_READ);
    while (true) {
      int select = selector.select(500);
      System.out.println("---select---");
      Set<SelectionKey> selectedKeys = selector.selectedKeys();
      for (SelectionKey selectionKey : selectedKeys) {
        if (selectionKey.isReadable()) {
          ByteBuffer allocate = ByteBuffer.allocate(1);
          SocketChannel channel = (SocketChannel) selectionKey.channel();
          channel.read(allocate);
          System.out.println(new String(allocate.array()));
          selectionKey.interestOps(SelectionKey.OP_ACCEPT);
        }
        selectedKeys.clear();
      }
    }
  }
}