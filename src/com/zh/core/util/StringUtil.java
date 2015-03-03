/**
 * Copyright 2005-2009 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2009-12-25
 */
package com.zh.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;


/**
 * StringUtil 工具类
 * 
 * @author Flouny.Caesar
 * 
 */
public class StringUtil extends StringUtils {

	/**
	 * 通过字符串驻留池来进行比较
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean intern(String str1, String str2) {
		if (str1 == null)
			return str2 == null;

		str1 = str1.intern();

		return (str1 == str2) ? true : false;
	}

	/**
	 * 将String aaBc 转为 aa_bc的格式 用于java bean 属性转为数据库字段名
	 * 
	 * @param str
	 * @return
	 */
	public static String propertyToFieldName(String str) {
		if (isEmpty(str))
			return str;

		if (str.charAt(0) > 'A' && str.charAt(0) < 'Z')
			return str;

		if (Character.isUpperCase(str.charAt(0)))
			str = Character.toString(Character.toLowerCase(str.charAt(0)))
					+ str.substring(1);

		for (int i = 1; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a >= 'A' && a <= 'Z') {
				if (str.charAt(i - 1) != '_') {
					str = str.replace(String.valueOf(a), ("_".concat(String
							.valueOf(a))).toLowerCase());
					i++;
				}

				continue;
			}
		}

		return str;
	}

	/**
	 * 判断字符串是否为空白，常见几种情况如下：
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 得到一个日期加随机数的字符串
	 * 
	 * @param length
	 *            随机数的个数，如不加随机数，则用0代替
	 * @return 如果length=8，返回形式为：20110318103647015PVje2TJO
	 */
	public static String getDateAndRandStr(int length) {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
				+ getRandomStr(length);
	}

	/**
	 * 随机获取指定长度的字符串(由数字与字母组成)：
	 * <p>
	 * 另：如果导入commons-lang.jar包，可用此类： <br>
	 * RandomStringUtils.randomAlphanumeric(length)
	 * 
	 * @param length
	 *            获取的长度
	 * @return 长度小于或等于0时，则返回""
	 */
	public static String getRandomStr(int length) {
		if (length <= 0) {
			return "";
		}

		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		return sb.toString();
	}

	/**
	 * 验证字符串是否是电话号码格式
	 * 
	 * @param strPhoneNum
	 * @return
	 */
	public static boolean checkPhoneNumberValid(String strPhoneNum)
	{
		boolean bool = false;
		
		//手机号码
		/**String checkphone = "^((\\+{0,1}86){0,1})((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern pattern = Pattern.compile(checkphone);
		Matcher matcher = pattern.matcher(strPhoneNum);
		bool = matcher.matches();
		*/
		if(strPhoneNum.length()==11 || strPhoneNum.length()==8 )
		{
			bool = true;
		}
		//座机号码
		/**if(!bool)
		{
			String studioPhone = "^(0[0-9]{2,3}\\-{0,1})?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$";
			pattern = Pattern.compile(studioPhone);
			matcher = pattern.matcher(strPhoneNum);
			bool = matcher.matches();
			
			
		}
*/
		return bool;

	}

}