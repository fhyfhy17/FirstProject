package com;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.LineBasedFrameDecoder;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.timeout.ReadTimeoutHandler;
import org.jboss.netty.util.HashedWheelTimer;

import com.Handler.ChannelHandler;
import com.Handler.Decoder;

public class NetWork {
	private ReadTimeoutHandler timeoutHandler;
	private ChannelPipelineFactory channelPipelineFactory;

	public NetWork() {
		HashedWheelTimer timer = new HashedWheelTimer();
		timeoutHandler = new ReadTimeoutHandler(timer, 600) {
			@Override
			protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
				ctx.getHandler();
				// 超时下线时执行的方法
			}
		};
		this.channelPipelineFactory = new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline cp = Channels.pipeline();
				cp.addLast("timeout", timeoutHandler);
				cp.addLast("line", new LineBasedFrameDecoder(1024));
				cp.addLast("string", new StringDecoder());
				cp.addLast("utf", new Decoder());
				cp.addLast("handle", new ChannelHandler());
				return cp;
			}
		};
	}

	public void start() {
		ServerBootstrap boot = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
		boot.setPipelineFactory(channelPipelineFactory);
		boot.setOption("child.bufferFactory", new HeapChannelBufferFactory());
		boot.bind(new InetSocketAddress(12200));
		System.out.println("服务启动在port:12200");
	}
}
