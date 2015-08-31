package com.Handler;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

public class Decoder extends OneToOneDecoder {

	@Override
	protected Object decode(ChannelHandlerContext arg0, Channel arg1, Object arg2) throws Exception {
		Charset c = Charset.forName("utf-8");
		arg2 = (ByteBuffer) arg2;
		return null;
	}

}
