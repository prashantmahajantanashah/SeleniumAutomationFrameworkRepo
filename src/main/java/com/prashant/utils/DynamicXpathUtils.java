package com.prashant.utils;

public final class DynamicXpathUtils {
	
	private DynamicXpathUtils() {
		
	}
	
	public static String getXpath(String submenuXpathText, String value) {
		String newXpath= String.format(submenuXpathText, value);
		return newXpath;
	}
	
	

}
