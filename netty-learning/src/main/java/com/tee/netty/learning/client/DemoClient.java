package com.tee.netty.learning.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author youchao.wen
 * @date 2021/1/10.
 */
@Slf4j
public class DemoClient {

    public void connect(int port, String host) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ClientHandler());

            //使用channelFuture来接接收来自服务端的数据
            //sync方法会阻塞等待知道获取数据
            ChannelFuture future = bootstrap.connect(host, port).sync();
            //等待服务端的通知也会关闭
            future.channel().closeFuture().sync();

        } catch (Exception e) {
            log.error("invoke  fail", e);
        } finally {
            //优雅关闭
            group.shutdownGracefully();
        }
    }

    static class ClientHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline()
                    .addLast(new FixedLengthFrameDecoder(1024))
                    .addLast(new StringDecoder());
        }
    }

}
