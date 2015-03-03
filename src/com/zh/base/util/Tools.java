package com.zh.base.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class Tools {
	
	/**
	 * 隐藏邮件地址的部分内容
	 * @param address
	 * @return
	 */
	public static String mailCover(String address){
		StringBuffer retStr = new StringBuffer();
		String[] addressArray = address.split("@");
		int addLen = addressArray[0].length();
		int len = 0;
		switch(addLen){
			case 0: len = 0; break;
			case 1: len = 1; break;
			case 2: len = 1; break;
			case 3: len = 2; break;
			case 4: len = 2; break;
			case 5: len = 3; break;
			case 6: len = 4; break;
			default:len = 4; break;
		}
		
		String addressTail = "";
		String addressCenter = "";
		if(addressArray.length > 1){
			addressTail = addressArray[1]; 
		}
		
		if(address.contains("@")){
			addressCenter = "@";
		}
		
		retStr.append(addressArray[0].substring(0, len) + "***" + addressCenter + addressTail);
		return retStr.toString();
	}
	
	
	/**
	 * 格式化 数值
	 * @param swiftNumber 流水号 例如：1
	 * @param STR_FORMAT  需要格式    0000
	 * @return 0001
	 */
	public static String numFormat(Long swiftNumber,String STR_FORMAT){
	    DecimalFormat df = new DecimalFormat(STR_FORMAT);
	    return df.format(swiftNumber);
	}
	
	public static void main(String[] args) {
		/*
		System.out.println(mailCover("a"));
		System.out.println(mailCover("a@"));
		System.out.println(mailCover("a@163.com"));
		System.out.println(mailCover("a1@163.com"));
		System.out.println(mailCover("a22@163.com"));
		System.out.println(mailCover("a333@163.com"));
		System.out.println(mailCover("a4444@163.com"));
		System.out.println(mailCover("a55555@163.com"));
		System.out.println(mailCover("a666666@163.com"));
		System.out.println(mailCover("a7777777@163.com"));
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
			passwordDigest = PasswordDigestUtil.doPasswordDigest(nonce, created, password);
			System.out.println("passwordDigest: " + passwordDigest);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//g1TfaGQppwtPpxhKLhFOCrFhKZk=
	}
}
