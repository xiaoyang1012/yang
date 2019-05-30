package com.yang.util;

import java.util.Random;

/**
 * 生成唯一id
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * 
 * @author	小仰
 * @date	
 * @version 1.0
 */
public class IDUtils {

	/**
	 * 获得图片名
	 */
	public static String genImageName() {
		//当前时间
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//拼接
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 获得id
	 */
	public static String genId() {
		//当前时间
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//拼接，补全位数
		String str = millis + String.format("%02d", end2);
	
		return str;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genId());
	}


}
