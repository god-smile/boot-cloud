package com.zxcv.commom.utils.app;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

public class ApprntSignUtil {

	public static String signRequest(Map<String, Object> params, String secret, String signMethod) throws IOException {
		// 第一步：检查参数是否已经排序
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);

		// 第二步： 把所有参数名和参数值串在一起
		StringBuilder query = new StringBuilder();
		if ("md5".equals(signMethod)) {
			query.append(secret);
		}
		for (String key : keys) {
			String value = params.get(key).toString();
			if (isNotEmpty(value)) {
				query.append(key).append(value);
			}
		}

		// 第三步：使用MD5/HMAC加密
		byte[] bytes;
		if ("hmac".equals(signMethod)) {
			//System.out.println(query.toString());
			bytes = encryptHMAC(query.toString(), secret);
		} else {
			query.append(secret);
			//System.out.println(query.toString());
			bytes = encryptMD5(query.toString());
		}
		// 第四步：把二进制转化为大写的十六进制
		return byte2hex(bytes);
	}

	/**
	 * 
	 * @param params
	 * @param secret
	 * @param signMethod
	 * @param ignoreCase 排序忽略大小写 直接按照字典序升序排序
	 * @return
	 * @throws IOException
	 */
	public static String signRequest(Map<String, Object> params, String secret, String signMethod,boolean ignoreCase ) throws IOException {
		// 第一步：检查参数是否已经排序
		String[] keys = params.keySet().toArray(new String[0]);
		if(ignoreCase){
			Arrays.sort(keys,String.CASE_INSENSITIVE_ORDER);
		}else{
			Arrays.sort(keys);
		}

		// 第二步： 把所有参数名和参数值串在一起
		StringBuilder query = new StringBuilder();
		if ("md5".equals(signMethod)) {
			query.append(secret);
		}
		for (String key : keys) {
			String value = params.get(key).toString();
			if (isNotEmpty(value)) {
				query.append(key).append(value);
			}
		}

		// 第三步：使用MD5/HMAC加密
		byte[] bytes;
		if ("hmac".equals(signMethod)) {
			System.out.println(query.toString());
			bytes = encryptHMAC(query.toString(), secret);
		} else {
			query.append(secret);
			System.out.println(query.toString());
			bytes = encryptMD5(query.toString());
		}
		// 第四步：把二进制转化为大写的十六进制
		return byte2hex(bytes);
	}

	
	
	
	
	
	
	public static byte[] encryptHMAC(String data, String secret) throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "hmac");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes("utf-8"));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.toString());
		}
		return bytes;
	}

	public static byte[] encryptMD5(String data) throws IOException {
		return encryptMD5(data.getBytes("utf-8"));
	}

	private static byte[] encryptMD5(byte[] data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			bytes = md.digest(data);
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.toString());
		}
		return bytes;
	}

	public static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}
	

	public static boolean isNotEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return false;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(value.charAt(i)) == false)) {
				return true;
			}
		}
		return false;
	}

}
