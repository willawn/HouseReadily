package com.huzhiyi.postserver.client;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.MapMaker;

public class ContextData {
	private static ConcurrentMap<String, ArrayList<String>> historyData = new MapMaker().makeMap();

	private static ConcurrentMap<String, Integer> viewId = new MapMaker().makeMap();

	private static ConcurrentMap<String, ArrayList<String>> viewIdData = new MapMaker().makeMap();

	public static ConcurrentMap<String, ArrayList<String>> getHistoryData() {
		return historyData;
	}

	public static ConcurrentMap<String, Integer> getViewId() {
		return viewId;
	}

	public static ConcurrentMap<String, ArrayList<String>> getViewIdData() {
		return viewIdData;
	}
	
}
