package com.vanvalt.util.token;
import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.tools.ant.taskdefs.Sleep;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
 
/**
 *
 * @author Charles
 */
public class TokenUtils {
 
    private static final String privateKey = "chenbo.wang@z5link.com;henan_zhengzhou_z5link;";
 
    public static String getToken(String password, String date) {
        return Hashing.md5().newHasher().
                putString(password, Charsets.UTF_8).
                putString(privateKey, Charsets.UTF_8).
                putString(date, Charsets.UTF_8).hash().toString();
    }
 
     
    public static String getToken(String password, Date date) {
        return Hashing.md5().newHasher().
                putString(password, Charsets.UTF_8).
                putString(privateKey, Charsets.UTF_8).
                putString(getDate(date), Charsets.UTF_8).hash().toString();
    }
 
     
    public static String getToken(String password) {
        return Hashing.md5().newHasher().
                putString(password, Charsets.UTF_8).
                putString(privateKey, Charsets.UTF_8).putString(getDate(), Charsets.UTF_8).hash().toString();
 
    }
 
    public static boolean validToken(String token, String password) {
        String confirm = getToken(password);
        if (confirm.equals(token)) {
            return true;
        } else {
            return false;
        }
    }
 
    public static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
 
    }
    public static String getDate(Date now) {
       
        return FastDateFormat.getInstance("yyyyMMddHH").format(now);
 
    }
    public static String getNextHour(Date now) {
        Date date = new Date(now.getTime()+60*60*1000);
         
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
 
    }
    
    public static String getNextHour(Date now,int hour) {
        Date date = new Date(now.getTime()+60*60*1000*hour);
         
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
 
    }
    
    public static String getNextDay(Date now) {
        Date date = new Date(now.getTime()+24*60*60*1000);
         
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
 
    }
    
    public static String getNextDay(Date now,int days) {
        Date date = new Date(now.getTime()+24*60*60*1000*days);
         
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
 
    }
    
    public static String getNextMonth(Date now) {
        Date date = new Date(now.getTime()+30*24*60*60*1000);
         
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
 
    }
     
     public static void main(String [] args) {
		// 判断Token是否合法，合法执行，并更新Token
		String token = "";
		String tokenNext = "";
		String password = "6b0685afede510200c7a00a666859267";

		if (!TokenUtils.validToken(token, password) && !TokenUtils.validToken(tokenNext, password)) {
			// 此处处理的未登录信息
			//return;
		}

		for (int i = 0; i < 10 ; i++) {
			
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date now = new Date(System.currentTimeMillis()+24*60*60*1000*30);
		token = TokenUtils.getToken(password, now);
		tokenNext = TokenUtils.getToken(password, TokenUtils.getNextDay(now));
		
		System.out.println("token     = " + token);
		System.out.println("tokenNext = " + tokenNext);
		}
	}
}