package com.vanvalt.util.comm;

import java.util.regex.Pattern;

public class Tools {

	public static boolean isBlankOrNull(String str){  
        if(null==str)return true;  
        //return str.length()==0?true:false;  
        return str.length()==0;  
    } 
	
	public static String replaceSpecialtyStr(String str,String pattern,String replace){  
        if(isBlankOrNull(pattern))  
            pattern="\\s*|\t|\r|\n";//去除字符串中空格、换行、制表  
        if(isBlankOrNull(replace))  
            replace="";  
        return Pattern.compile(pattern).matcher(str).replaceAll(replace);  
           
    }  
}
