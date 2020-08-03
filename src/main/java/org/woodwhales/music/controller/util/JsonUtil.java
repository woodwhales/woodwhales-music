package org.woodwhales.music.controller.util;

import com.google.gson.Gson;

public class JsonUtil {

	private JsonUtil() {}
	
	private static Gson gson = new Gson();
	
	public static String toString(Object src) {
		return gson.toJson(src);
	}
}
