package chap08.sect04;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
public class NettyClientTest {
  public static void main(String[] args) throws InterruptedException {
    new io.netty.bootstrap.Bootstrap()
    .group(new io.netty.channel.nio.NioEventLoopGroup())
    .channel(io.netty.channel.socket.nio.NioSocketChannel.class)
    .handler(new ChannelInitializer<io.netty.channel.Channel>() {
      protected void initChannel(io.netty.channel.Channel ch) throws Exception {
        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
          public void channelActive(ChannelHandlerContext ctx) throws Exception {
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer("hello server".getBytes()));
          }
          public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
            System.out.println(((ByteBuf)msg).toString(CharsetUtil.UTF_8));
      } }); }
    }).connect(new java.net.InetSocketAddress("localhost", 5000))
    .sync();
} }