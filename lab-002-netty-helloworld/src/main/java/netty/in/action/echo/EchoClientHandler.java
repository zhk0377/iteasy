package netty.in.action.echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @Description: EchoClientHandler
 * @Author kai.zheng@abite.com
 * @Date 2021/9/5
 */
@Slf4j
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private int counter;
    private static final String ECHO_REQ = "hello server.服务器好啊。^^";

    /**
     * 客户端和服务端TCP链路建立成功过后，此方法调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes(StandardCharsets.UTF_8)));
        }
    }

    /**
     * 接收到服务端数据时调用
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("this is : {} receive server msg : {} ", ++counter, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("client error:", cause);
        ctx.close();
    }
}
