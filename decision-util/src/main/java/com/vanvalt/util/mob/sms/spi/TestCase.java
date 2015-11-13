package com.vanvalt.util.mob.sms.spi;

import com.vanvalt.util.mob.sms.utils.MobClient;

/**
 * 
 * 娴嬭瘯
 * @author Administrator
 */
public class TestCase {

	public static void main(String[] args) throws Exception {

		String result = status();
		System.out.println(result);
		
	}
	
	
	/**
	 * 鏈嶅姟绔繍琛岀姸鎬�	 * @return
	 * @throws Exception
	 */
	public static String status() throws Exception{
		
		String address = "https://api.sms.mob.com/sms/verify";
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
	
	
}
