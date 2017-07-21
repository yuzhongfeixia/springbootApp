/**
 * MD5.java created by 杨浩(yanghao) at 2009-12-25
 * 
 * SaCool
 * 			网  址: http://www.sacool.com
 * SaCool. 版权所有.
 */
package com.afis.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 *
 * @author 杨浩(yanghao),2009-12-25 下午03:15:26
 * @version 1.0.0
 * @see Coder
 *
 * @version <a href="http://www.sacool.com">SaCool</a><br>
 * 			SaCool. &copy; 版权所有.
 */
public class MD5 {
	private static final byte[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	private static MessageDigest getInstance() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * MD5加密 <br>
	 * <br>
	 * {@link MD5}.md5 created by afis06 at 2013-4-15 下午4:41:24
	 *
	 * @param src
	 *            需要加密的源字节数组
	 * @param offset
	 *            开始位置
	 * @param length
	 *            字节长度
	 * @return
	 */
	public static byte[] md5(byte[] src, int offset, int length) {
		MessageDigest digest = getInstance();
		digest.update(src, offset, length);
		return digest.digest();
	}

	private static byte[] to16(byte[] md5Code, byte[] digits) {
		byte[] b = new byte[md5Code.length];
		for (int i = 0; i < md5Code.length / 2; i++) {
			b[2 * i] = digits[md5Code[i + 4] >>> 4 & (digits.length - 1)];
			b[2 * i + 1] = digits[md5Code[i + 4] & (digits.length - 1)];
		}
		return b;
	}

	private static byte[] to32(byte[] md5Code, byte[] digits) {
		byte[] b = new byte[md5Code.length * 2];
		for (int i = 0; i < md5Code.length; i++) {
			b[2 * i] = digits[md5Code[i] >>> 4 & (digits.length - 1)];
			b[2 * i + 1] = digits[md5Code[i] & (digits.length - 1)];
		}
		return b;
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @param offset
	 *            开始位置
	 * @param length
	 *            长度
	 * @param digits
	 *            显示字符集
	 * @return 16位MD5字符串
	 */
	public static String code16(byte[] src, int offset, int length, byte[] digits) {
		return new String(to16(md5(src, offset, length), digits));
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @param digits
	 *            显示字符集
	 * @return 16位MD5字符串
	 */
	public static String code16(byte[] src, byte[] digits) {
		return code16(src, 0, src.length, digits);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * 默认字符集:{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	 * 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
	 * 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
	 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	 * 't', 'u', 'v', 'w', 'x', 'y', 'z' } <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @param offset
	 *            开始位置
	 * @param length
	 *            长度
	 * @return 16位MD5字符串
	 */
	public static String code16(byte[] src, int offset, int length) {
		return code16(src, offset, length, digits);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * 默认字符集:{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	 * 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
	 * 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
	 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	 * 't', 'u', 'v', 'w', 'x', 'y', 'z' } <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @return 16位MD5字符串
	 */
	public static String code16(byte[] src) {
		return code16(src, 0, src.length);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param str
	 *            要加密的字符串
	 * @param digits
	 *            显示字符集
	 * @return 16位MD5字符串
	 */
	public static String code16(String str, String digits) {
		return code16(str.getBytes(), digits.getBytes());
	}

	/**
	 * 加密 <br>
	 * <br>
	 * 默认字符集:{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	 * 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
	 * 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
	 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	 * 't', 'u', 'v', 'w', 'x', 'y', 'z' } <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param str
	 *            要加密的字符串
	 * @return 16位MD5字符串
	 */
	public static String code16(String str) {
		return code16(str.getBytes());
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @param offset
	 *            开始位置
	 * @param length
	 *            长度
	 * @param digits
	 *            显示字符集
	 * @return 32位MD5字符串
	 */
	public static String code32(byte[] src, int offset, int length, byte[] digits) {
		return new String(to32(md5(src, offset, length), digits));
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @param digits
	 *            显示字符集
	 * @return 32位MD5字符串
	 */
	public static String code32(byte[] src, byte[] digits) {
		return code32(src, 0, src.length, digits);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * 默认字符集:{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	 * 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
	 * 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
	 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	 * 't', 'u', 'v', 'w', 'x', 'y', 'z' } <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @param offset
	 *            开始位置
	 * @param length
	 *            长度
	 * @return 32位MD5字符串
	 */
	public static String code32(byte[] src, int offset, int length) {
		return code32(src, offset, length, digits);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * 默认字符集:{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	 * 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
	 * 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
	 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	 * 't', 'u', 'v', 'w', 'x', 'y', 'z' } <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param src
	 *            要加密的字节数组
	 * @return 32位MD5字符串
	 */
	public static String code32(byte[] src) {
		return code32(src, 0, src.length);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param str
	 *            要加密的字符串
	 * @param digits
	 *            显示字符集
	 * @return 32位MD5字符串
	 */
	public static String code32(String str, byte[] digits) {
		return code32(str.getBytes(), digits);
	}

	/**
	 * 加密 <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param str
	 *            要加密的字符串
	 * @param digits
	 *            显示字符集
	 * @return 32位MD5字符串
	 */
	public static String code32(String str, String digits) {
		return code32(str.getBytes(), digits.getBytes());
	}

	/**
	 * 加密 <br>
	 * <br>
	 * 默认字符集:{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	 * 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
	 * 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
	 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	 * 't', 'u', 'v', 'w', 'x', 'y', 'z' } <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-5-8 上午03:25:44
	 *
	 * @param str
	 *            要加密的字节数组
	 * @return 32位MD5字符串
	 */
	public static String code32(String str) {
		return code32(str.getBytes());
	}

	/**
	 * 文件16位MD5编码 <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-7-8 下午06:54:27
	 *
	 * @param inputStream
	 * @param digits
	 * @return
	 * @throws IOException
	 */
	public static String code16(InputStream inputStream, byte[] digits) throws IOException {
		MessageDigest digest = getInstance();
		byte[] b = new byte[1024];
		int len;
		while ((len = inputStream.read(b)) > 0) {
			digest.update(b, 0, len);
		}
		return new String(to16(digest.digest(), digits));
	}

	/**
	 * 文件16位MD5编码 <br>
	 * <br>
	 * {@link MD5}.code16 created by yanghao(杨浩) at 2011-7-8 下午06:54:27
	 *
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String code16(InputStream inputStream) throws IOException {
		return code16(inputStream, digits);
	}

	/**
	 * 文件32位MD5编码 <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-7-8 下午06:54:37
	 *
	 * @param inputStream
	 * @param digits
	 * @return
	 * @throws IOException
	 */
	public static String code32(InputStream inputStream, byte[] digits) throws IOException {
		MessageDigest digest = getInstance();
		byte[] b = new byte[1024];
		int len;
		while ((len = inputStream.read(b)) > 0) {
			digest.update(b, 0, len);
		}
		return new String(to32(digest.digest(), digits));
	}

	/**
	 * 文件32位MD5编码 <br>
	 * <br>
	 * {@link MD5}.code32 created by yanghao(杨浩) at 2011-7-8 下午06:54:37
	 *
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String code32(InputStream inputStream) throws IOException {
		return code32(inputStream, digits);
	}
}
