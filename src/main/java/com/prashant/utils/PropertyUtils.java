package com.prashant.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.prashant.constants.FrameworkConstants;
import com.prashant.enums.ConfigProperties;

public final class PropertyUtils {
	
	private PropertyUtils(){
			
	}
	private static Properties prop =new Properties();
	private static final Map<String, String> map = new HashMap<String, String>();
	
	static {
		
		try {
		FileInputStream file = new FileInputStream(FrameworkConstants.getConfigPFilePath());
		prop.load(file);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		for(Object a: prop.keySet()) {
			map.put(String.valueOf(a), String.valueOf(prop.get(a)).trim());//added tri to remove space from property file value
		}
		
	}
	//hashtable is therad safe buut slow
	
	public static String get(ConfigProperties key) throws Exception {
		
		if(Objects.isNull(map.get(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase()) ) {
			throw new Exception("Property name: "+ key + " is not found. Please check config.properties");
		}
		
		return map.get(key.name().toLowerCase());
	}
	
	
	
//	public static String getValue(String key) throws Exception {
//		
//		if(Objects.isNull(prop.getProperty(key)) ||Objects.isNull(key) ) {
//			throw new Exception("Property name: "+ key + " is not found. Please check config.properties");
//		}
//		
//		return prop.getProperty(key);
//		
//	}

}
