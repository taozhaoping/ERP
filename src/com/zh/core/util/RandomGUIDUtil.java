package com.zh.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zh.base.action.mainAction;

public class RandomGUIDUtil {

	/**
	 * 日志管理类对象
	 */

	private static Logger LOGGER = LoggerFactory.getLogger(mainAction.class); 

	public String valueBeforeMD5 = "";

	public String valueAfterMD5 = "";

	private static Random myRand;

	private static SecureRandom mySecureRand;

	private static String S_ID;

	/**
	 * 静态块初始化
	 */
	static {

		mySecureRand = new SecureRandom();

		long secureInitializer = mySecureRand.nextLong();

		myRand = new Random(secureInitializer);

		try {

			S_ID = InetAddress.getLocalHost().toString();

		} catch (UnknownHostException e) {

			System.out.println("构造带指定详细消息和嵌入异常!");

		}

	}

	public RandomGUIDUtil() throws Exception {

		getRandomGUID(false);
	}

	public RandomGUIDUtil(boolean secure) throws Exception {

		getRandomGUID(secure);
	}

	/**
	 * 
	 * 随机生成 GUID
	 */

	private void getRandomGUID(boolean secure) throws Exception {

		MessageDigest md5 = null;

		StringBuffer sbValueBeforeMD5 = new StringBuffer();

		try {

			md5 = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {

			LOGGER.error("初始化MD5出错！");

			throw

			new NoSuchAlgorithmException("初始化MD5出错！");

		}

		try {

			long time = System.currentTimeMillis();

			long rand = 0;

			if (secure) {

				rand = mySecureRand.nextLong();

			} else {

				rand = myRand.nextLong();

			}

			sbValueBeforeMD5.append(S_ID);

			sbValueBeforeMD5.append(":");

			sbValueBeforeMD5.append(Long.toString(time));

			sbValueBeforeMD5.append(":");

			sbValueBeforeMD5.append(Long.toString(rand));

			valueBeforeMD5 = sbValueBeforeMD5.toString();

			md5.update(valueBeforeMD5.getBytes());

			byte[] array = md5.digest();

			StringBuffer sb = new StringBuffer();

			for (int j = 0; j < array.length; ++j) {

				int b = array[j] & 0xFF;

				if (b < 0x10)
					sb.append('0');

				sb.append(Integer.toHexString(b));

			}

			valueAfterMD5 = sb.toString();

		} catch (Exception e) {

			LOGGER.error("获得MD5加密码出错!");

			throw

			new Exception("初始化MD5出错！");

		}
	}

	/**
	 *  生成一个 GUID 串* 
	 @return GUID
	 @throws Exception
	 */
	public static String newGuid() throws Exception {

		RandomGUIDUtil rdmGUID = new RandomGUIDUtil();

		return rdmGUID.toString();
	}

	/**
	 * 生成以主机串号、显卡串号、主板号，以保证唯一性的 32 位编码
	 */
	public String toString() {

		String raw = valueAfterMD5.toUpperCase();

		StringBuffer sb = new StringBuffer();

		sb.append(raw.substring(0, 8));

		sb.append(raw.substring(8, 12));

		sb.append(raw.substring(12, 16));

		sb.append(raw.substring(16, 20));

		sb.append(raw.substring(20));

		return sb.toString();
	}
}
