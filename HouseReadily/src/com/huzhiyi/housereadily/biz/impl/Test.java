package com.huzhiyi.housereadily.biz.impl;

import com.huzhiyi.utils.Configuration;

public class Test {

	/**
	 * @Title: main
	 * @Description: 描述方法
	 * 		<p>
	 * @author willter
	 * @date 2013-5-23
	 * 		<p>
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("============" + isBigVersion("1.3.3"));
	}

	private static boolean isBigVersion(String version) {
		String str1 = version;
		String str2 = "1.2.2";
		String[] s1 = str1.split("\\.");
		String[] s2 = str2.split("\\.");

		int n1 = s1.length;
		int n2 = s2.length;
		if (n1 == n2) {
			for (int i = 0; i < n1; i++) {
				if (Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]) > 0) {
					return true;
				}
				if (Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]) < 0) {
					return false;
				}
			}
		}
		if (n1 < n2) {
			return false;
		}
		if (n1 > n2) {
			return true;
		}
		return true;
	}
}
