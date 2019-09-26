package com.homolo.homolo.test;

import com.homolo.homolo.utils.EncryptionUtil;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: ZH
 * @Description:
 * @Date: 19-9-24 下午4:04
 */
public class encryptionTest {

	public static final String text = "zhuhui";
	@Test
	public void test1() throws NoSuchAlgorithmException {
		MessageDigest sha = MessageDigest.getInstance("sha");
		sha.update(text.getBytes());
		byte []shaBin = sha.digest();
		printBytes(shaBin);
		System.out.println(EncryptionUtil.encode(text));
	}

	public static void printBytes(byte[] b) {
		for(int i=0;i<b.length;i++) {
			System.out.printf("%02X", b[i]);
		}
		System.out.println();
	}

}
