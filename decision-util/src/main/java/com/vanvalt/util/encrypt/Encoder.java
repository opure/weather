package com.vanvalt.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * 加密算法.
 * 
 * @author wangchenbo
 * 
 */
@SuppressWarnings("restriction")
public class Encoder {

	public final static String MD5 = "MD5";
	public final static String UTF_8 = "utf-8";
	// md5加密
	public static final String EncoderPwdByMd5(String str)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 字符串反转
		str = new StringBuffer(str).reverse().toString();
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance(Encoder.MD5);

		BASE64Encoder base64en = new BASE64Encoder();

		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes(Encoder.UTF_8)));

		return newstr;

	}

	//对原始字符串进行md5的hash计算(客户端算法)
	public static String md5(String string){
        byte[] hash;
        try{
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        }
        catch (UnsupportedEncodingException e){
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
        
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash){
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
	
	public static void main(String[] args) {
		String str ="111111";
		System.out.println(Encoder.md5(str));
	}
	
}
