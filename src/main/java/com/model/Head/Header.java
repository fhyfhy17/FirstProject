package com.model.Head;

/**
 * @author Administrator 协议分为协议头和协议数据 协议{ 协议头(header) 协议数据(data) }
 * 
 *         协议头格式
 *         header协议格式{ tag byte 协议头标志位 encode byte 数据编码格式 encrypt byte 加密类型
 *         extend1 byte 用于扩展协议 extend2 byte sessionid string length[32] session
 *         length int 协议数据(data)长度 commandId int 协议号 }
 */
public class Header implements Cloneable {
	/** 数据编码格式。已定义：0：UTF-8，1：GBK，2：GB2312，3：ISO8859-1 **/
	private byte encode;
	/** 加密类型。0表示不加密 **/
	private byte encrypt;
	/** 用于扩展协议。暂未定义任何值 **/
	private byte extend1;
	/** 用于扩展协议。暂未定义任何值 **/
	private byte extend2;
	/** 会话ID **/
	private String sessionid;
	/** 数据包长 **/
	private int length;
	/** 命令 **/
	private int commandId;

	public Header() {

	}

	public Header(String sessionid) {
		this.encode = 0;
		this.encrypt = 0;
		this.sessionid = sessionid;
	}

	public Header(byte encode, byte encrypt, byte extend1, byte extend2, String sessionid, int length, int commandId) {
		this.encode = encode;
		this.encrypt = encrypt;
		this.extend1 = extend1;
		this.extend2 = extend2;
		this.sessionid = sessionid;
		this.length = length;
		this.commandId = commandId;
	}

	@Override
	public String toString() {
		return "header [encode=" + encode + ",encrypt=" + encrypt + ",extend1=" + extend1 + ",extend2=" + extend2 + ",sessionid=" + sessionid + ",length=" + length + ",commandId=" + commandId + "]";
	}

	@Override
	public Header clone() {
		try {
			return (Header) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte getEncode() {
		return encode;
	}

	public void setEncode(byte encode) {
		this.encode = encode;
	}

	public byte getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(byte encrypt) {
		this.encrypt = encrypt;
	}

	public byte getExtend1() {
		return extend1;
	}

	public void setExtend1(byte extend1) {
		this.extend1 = extend1;
	}

	public byte getExtend2() {
		return extend2;
	}

	public void setExtend2(byte extend2) {
		this.extend2 = extend2;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

}
