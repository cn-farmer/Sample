package chap12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class ReceiveInfoCallable implements Callable<List<IStudent<Number>>> {
  @Override
  public List<IStudent<Number>> call() throws Exception {
    try {
      ServerSocketChannel open = ServerSocketChannel.open();
      open.bind(new InetSocketAddress(5000));
      open.configureBlocking(false);
      Selector selector = Selector.open();
      open.register(selector, SelectionKey.OP_ACCEPT);

      while (true) {
        selector.select();
        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        for (SelectionKey selectionKey : selectedKeys) {
          if (selectionKey.isAcceptable()) {
            ServerSocketChannel serverChannel= (ServerSocketChannel) selectionKey.channel();
            SocketChannel accept = serverChannel.accept();
            accept.configureBlocking(false);
            accept.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
          }
          if (selectionKey.isReadable()) {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);
            while (channel.read(byteBuffer) > 0) {
              baos.write(byteBuffer.array());
              byteBuffer.position(0);
            }

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            @SuppressWarnings("unchecked")
            List<IStudent<Number>> studentList = (List<IStudent<Number>>) ois.readObject();
            return studentList;
          }
        }
        selectedKeys.clear();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}