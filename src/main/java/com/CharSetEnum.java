package com;

public enum CharSetEnum {
	INSTANCE, ;

	public String getInt(int encode) {
		switch (encode) {
		case 0:
			return "UTF-8";
		case 1:
			return "GBK";
		case 2:
			return "GB2312";
		case 3:

			return "ISO8858-1";
		default:
			return "UTF-8";
		}

	}

}
