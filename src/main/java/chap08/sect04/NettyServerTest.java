package chap08.sect04;
import io.netty.channel.*;
public class NettyServerTest {
  public static void main(String[] args) {
    new io.netty.bootstrap.ServerBootstrap()
      .group(new io.netty.channel.nio.NioEventLoopGroup())
      .channel(io.netty.channel.socket.nio.NioServerSocketChannel.class)
      .childHandler(new ChannelInitializer<io.netty.channel.Channel>() {
          protected void initChannel(io.netty.channel.Channel ch) throws Exception {
            ch.pipeline().addLast(new io.netty.handler.codec.string.StringEncoder());
            ch.pipeline().addLast( new io.netty.handler.codec.string.StringDecoder());
            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
              public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                System.out.println(msg);
                ctx.channel().writeAndFlush("hello client");
                super.channelRead(ctx, msg);
          } }); }
        }).bind(5000);
} }