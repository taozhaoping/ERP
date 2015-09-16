package com.zh.base.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class Tools {

	/**
	 * 隐藏邮件地址的部分内容
	 * 
	 * @param address
	 * @return
	 */
	public static String mailCover(String address) {
		StringBuffer retStr = new StringBuffer();
		String[] addressArray = address.split("@");
		int addLen = addressArray[0].length();
		int len = 0;
		switch (addLen) {
		case 0:
			len = 0;
			break;
		case 1:
			len = 1;
			break;
		case 2:
			len = 1;
			break;
		case 3:
			len = 2;
			break;
		case 4:
			len = 2;
			break;
		case 5:
			len = 3;
			break;
		case 6:
			len = 4;
			break;
		default:
			len = 4;
			break;
		}

		String addressTail = "";
		String addressCenter = "";
		if (addressArray.length > 1) {
			addressTail = addressArray[1];
		}

		if (address.contains("@")) {
			addressCenter = "@";
		}

		retStr.append(addressArray[0].substring(0, len) + "***" + addressCenter
				+ addressTail);
		return retStr.toString();
	}

	/**
	 * 格式化 数值
	 * 
	 * @param swiftNumber
	 *            流水号 例如：1
	 * @param STR_FORMAT
	 *            需要格式 0000
	 * @return 0001
	 */
	public static String numFormat(Long swiftNumber, String STR_FORMAT) {
		DecimalFormat df = new DecimalFormat(STR_FORMAT);
		return df.format(swiftNumber);
	}

	/**
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零 要用到正则表达式
	 */
	public static String digitUppercase(double totaltotal) {
		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

		String head = totaltotal < 0 ? "负" : "";
		totaltotal = Math.abs(totaltotal);

		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			s += (digit[(int) (Math.floor(totaltotal * 10 * Math.pow(10, i)) % 10)] + fraction[i])
					.replaceAll("(零.)+", "");
		}
		if (s.length() < 1) {
			s = "整";
		}
		int integerPart = (int) Math.floor(totaltotal);

		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && totaltotal > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i]
					+ s;
		}
		return head
				+ s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "")
						.replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
	}

	public static void main(String[] args) {
		/*
		 * System.out.println(mailCover("a"));
		 * System.out.println(mailCover("a@"));
		 * System.out.println(mailCover("a@163.com"));
		 * System.out.println(mailCover("a1@163.com"));
		 * System.out.println(mailCover("a22@163.com"));
		 * System.out.println(mailCover("a333@163.com"));
		 * System.out.println(mailCover("a4444@163.com"));
		 * System.out.println(mailCover("a55555@163.com"));
		 * System.out.println(mailCover("a666666@163.com"));
		 * System.out.println(mailCover("a7777777@163.com"));
		 */
		String nonce = "oQsDzjKbtB+0oGwResHXQQ==";
		

		try {
			System.out.println(Base64.decode(nonce).length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String created = "2014-05-30T02:03:27.890Z";
		String password = "test";

		String passwordDigest;
		try {
			passwordDigest = PasswordDigestUtil.doPasswordDigest(nonce,
					created, password);
			System.out.println("passwordDigest: " + passwordDigest);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// g1TfaGQppwtPpxhKLhFOCrFhKZk=
	}
}
