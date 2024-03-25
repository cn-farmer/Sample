package chap08.sect02;
import java.nio.ByteBuffer;
import java.nio.channels.*;
public class AIOServerTest {
  public static void main(String[] args) throws Exception {
    System.out.println("main thread:" + Thread.currentThread().getName());
    var assc = AsynchronousServerSocketChannel.open().bind(new java.net.InetSocketAddress(5000));
    assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

      public void completed(AsynchronousSocketChannel asc, Object attachment) {
        System.out.println("accept thread:" + Thread.currentThread().getName());
          ByteBuffer buffer = java.nio.ByteBuffer.allocate(1024);
          asc.read(buffer, null, new CompletionHandler<Integer, Object>() {

            public void completed(Integer result, Object attachment) {
              System.out.println("read thread:" + Thread.currentThread().getName());
              System.err.println( new String(buffer.array()));
              ByteBuffer bf = ByteBuffer.wrap("hello client".getBytes());
              asc.write(bf, asc, new CompletionHandler<Integer, AsynchronousSocketChannel>() {

                public void completed(Integer result, AsynchronousSocketChannel att) {
                  System.out.println("write thread:" + Thread.currentThread().getName());
                }
                public void failed(Throwable ex, AsynchronousSocketChannel att) {} 
              });
            }
          public void failed(Throwable ex, Object attachment) { ex.printStackTrace(); } 
        });
        assc.accept(null, this);
      }
      public void failed(Throwable ex, Object attachment) { ex.printStackTrace(); }
    });
    System.in.read();
  }
}