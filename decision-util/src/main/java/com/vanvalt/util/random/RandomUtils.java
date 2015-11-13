package com.vanvalt.util.random;

import java.util.Random;

public class RandomUtils {

	/**
     * java中如何获取某个范围内的随机数 
     * @param a
     * @param b
     * @return
     */
	public static int generateRandom(int a, int b){
		 int temp = 0;
	        try {
	            if (a > b) {
	                temp = new Random().nextInt(a - b);
	                return temp + b;
	            } else {
	                temp = new Random().nextInt(b - a);
	                return temp + a;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return temp + a;
	}
	
	public static void main(String[] args){
		
		int r = generateRandom(1,10);
		System.out.println(r);
	}
}
