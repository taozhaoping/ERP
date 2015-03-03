package com.zh.base.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordDigestUtil {

	/**
	 * A cached pseudo-random number generator NB. On some JVMs, caching this
	 * random number generator is required to overcome punitive overhead.
	 */
	private static SecureRandom random = null;

	/**
	 * Generate a nonce of the given length using the SHA1PRNG algorithm. The
	 * SecureRandom instance that backs this method is cached for efficiency.
	 * 
	 * @return a nonce of the given length
	 * @throws NoSuchAlgorithmException
	 * @throws WSSecurityException
	 */
	public static synchronized byte[] generateNonce(int length)
			throws NoSuchAlgorithmException {
		if (random == null) {
			random = SecureRandom.getInstance("SHA1PRNG");
		}
		byte[] temp = new byte[length];
		random.nextBytes(temp);
		return temp;
	}

	public static String doPasswordDigest(String nonce, String created,
			byte[] password) {
		String passwdDigest = null;
		try {
			byte[] b1 = nonce != null ? Base64.decode(nonce) : new byte[0];
			byte[] b2 = created != null ? created.getBytes("UTF-8")
					: new byte[0];
			byte[] b3 = password;
			byte[] b4 = new byte[b1.length + b2.length + b3.length];
			int offset = 0;
			System.arraycopy(b1, 0, b4, offset, b1.length);
			offset += b1.length;

			System.arraycopy(b2, 0, b4, offset, b2.length);
			offset += b2.length;

			System.arraycopy(b3, 0, b4, offset, b3.length);

			byte[] digestBytes = generateDigest(b4);
			passwdDigest = Base64.encode(digestBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passwdDigest;
	}

	public static String doPasswordDigest(String nonce, String created,
			String password) throws UnsupportedEncodingException {
		String passwdDigest = null;
		passwdDigest = doPasswordDigest(nonce, created,	password.getBytes("UTF-8"));
		return passwdDigest;
	}

	public static synchronized byte[] generateDigest(byte[] inputBytes)
			throws NoSuchAlgorithmException {
		MessageDigest digest = null;
		if (digest == null) {
			digest = MessageDigest.getInstance("SHA-1");
		}
		return digest.digest(inputBytes);
	}
}
