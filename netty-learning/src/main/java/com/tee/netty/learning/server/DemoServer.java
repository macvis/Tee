package com.tee.netty.learning.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * @author youchao.wen
 * @date 2021/1/10.
 */
@Slf4j
public class DemoServer {
    public void bind(int port){
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup dataGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(workGroup, dataGroup)
//                    .channel()
//                    .option()
                    .childHandler(new ServerHandler());

            ChannelFuture future = serverBootstrap.bind(port).sync();
        }catch(Exception e){
            log.error("invoke xxxx fail", e);
        }finally {
            workGroup.shutdownGracefully();
            dataGroup.shutdownGracefully();
        }
    }

    static class ServerHandler extends ChannelHandlerAdapter {
        public void channelRead(){

        }
    }

}

