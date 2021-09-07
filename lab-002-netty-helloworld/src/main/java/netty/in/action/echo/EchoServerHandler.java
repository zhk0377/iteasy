package netty.in.action.echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @Description: EchoServerHandler
 * @Author kai.zheng@abite.com
 * @Date 2021/9/5
 */
@Slf4j
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        log.info("this is:{} times receive lient msg: {}", ++counter, body);
        body += "^^";
        //此处讲数据写回到客户端，如果使用的ctx.write方法这个只会将数据写入缓冲区，需要再次调用ctx.flush方法
        ctx.writeAndFlush(Unpooled.copiedBuffer(body.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("error", cause);
        ctx.close();
    }
}
