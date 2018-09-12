package com.huzhiyi.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class StringUtil {

	public static String replace(String strSource, String strFrom, String strTo) {
		if (strSource == null || strSource.length() == 0)
			return "";
		if (strFrom == null || strFrom.equals(""))
			return strSource;
		String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;
		// System.out.println(strSource);
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;
		return strDest;
	}

	public static boolean isSameDay(Date date1, Date date2) {
		String DATE_FORMAT = "yyyy-MM-dd ";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		String date1Str = sdf.format(date1);
		String date2Str = sdf.format(date2);
		return date1Str.equals(date2Str);
	}

	public static String encodeUtf8(String str) {
		try {
			str = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return str;
	}

	public static String decodeUtf8(String str) {
		try {
			str = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {

		}
		return str;
	}

	public static String getSplitStr(String[] strSplit, int index) {
		if (index > strSplit.length - 1) {
			return "";
		} else {
			return strSplit[index];
		}
	}

	public static HashSet getHashSet(String[] strSplit) {
		HashSet equitmentSet = new HashSet();
		for (int i = 0; i < strSplit.length; i++) {
			equitmentSet.add(strSplit[i]);
		}
		return equitmentSet;
	}

	public static String[] getStrings(HashSet needSet) {
		String[] strs = new String[needSet.size()];
		Iterator<String> it = needSet.iterator();
		int i = 0;
		while (it.hasNext()) {
			strs[i] = it.next();
			i++;
		}
		return strs;
	}

	public static String[] getStrings(ArrayList<String> needSet) {
		String[] strs = new String[needSet.size()];
		Iterator<String> it = needSet.iterator();
		int i = 0;
		while (it.hasNext()) {
			strs[i] = it.next();
			i++;
		}
		return strs;
	}

	public static String[] replaceSplitStr(String[] strSplit, int index, String value) {
		if (index > strSplit.length - 1) {
			return strSplit;
		} else {
			strSplit[index] = value;
			return strSplit;
		}
	}

	public static String getStr(String[] strSplit, String split) {
		String str = "";
		for (int i = 0; i < strSplit.length; i++) {
			str += strSplit[i];
			if (i < strSplit.length - 1)
				str += split;
		}
		return str;
	}

	public static String getDoubleValue(Double a) {
		int b = a.intValue();
		if (b != a) {
			return a.toString();
		} else {
			return String.valueOf(b);
		}
	}
}
