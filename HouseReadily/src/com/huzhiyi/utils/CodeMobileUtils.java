package com.huzhiyi.utils;

import java.util.Date;
import java.util.Random;

public class CodeMobileUtils {

	public static String getCode() {
		return getCode(6);
	}

	public static String getCode(Integer length) {
		Date d = new Date();
		long lseed = d.getTime();
		Random r = new Random(lseed); // 设置随机种子
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < length; i++) {
			str.append(r.nextInt(10)); // 生成随机数字
		}
		return str.toString();
	}

	public static String getCode(Integer minNum, Integer maxNum, Integer length) {
		Date d = new Date();
		long lseed = d.getTime();
		Random r = new Random(lseed); // 设置随机种子
		StringBuffer str = new StringBuffer();
		for (; str.length() < length;) {
			int num = r.nextInt(maxNum + 1);
			if (num >= minNum) {
				str.append(num); // 生成随机数字
			}
		}
		return str.toString();
	}
	
	public static String getCode2(Integer length) {
		Date d = new Date();
		long lseed = d.getTime();
		Random r = new Random(lseed); // 设置随机种子
		StringBuffer str = new StringBuffer("");
		for (int i = 0; str.length() < length; i++) {
			int a = r.nextInt(10);
			if(!(str.length()==0 && a == 0)){
				if(str.indexOf(String.valueOf(a))<0){
					str.append(a); // 生成随机数字
				}
			}
			
		}
		return str.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("============" + getCode(1, 9, 6));
		}
	}
}
