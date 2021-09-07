package netty.in.action.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @Description: echo服务端
 * @Author kai.zheng@abite.com
 * @Date 2021/9/5
 */
@Slf4j
public class EchoServer {
    static final int port = 9090;

    public static void main(String[] args) throws InterruptedException {
        /*此线程组用于服务端接收客户端的连接*/
        EventLoopGroup boss = new NioEventLoopGroup();
        /*此线程组用于处理SocketChannel的读写操作*/
        EventLoopGroup worker = new NioEventLoopGroup();
        /*netty启动服务端的辅助类*/
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)//对应的是ServerSocketChannel类
                .option(ChannelOption.SO_BACKLOG, 128)
                .handler(new LoggingHandler(LogLevel.TRACE))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ByteBuf delimiter = Unpooled.copiedBuffer("^^".getBytes(StandardCharsets.UTF_8));
                        /*表示客户端的数据中如果出现^^就表示是一个完整的包，
                         *maxFrameLength这个表示如果在这个多字节中还没有出现则表示数据有异常情况，抛出异常
                         */
                        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                        //讲接收到的数据转换为String类型
                        socketChannel.pipeline().addLast(new StringDecoder(StandardCharsets.UTF_8));
                        //接收到的数据由自己的EchoServerHandler类进行处理
                        socketChannel.pipeline().addLast(new EchoServerHandler());
                    }
                });
        //绑定端口，同步等待成功
        ChannelFuture future = bootstrap.bind(port).sync();
        log.info("服务启动，端口号：[{}]", port);
        //等待服务端链路关闭后，main线程退出
        future.channel().closeFuture().sync();
        //关闭线程池资源
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }
}
