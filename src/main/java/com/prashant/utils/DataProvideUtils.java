package com.prashant.utils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.prashant.constants.FrameworkConstants;

public final class DataProvideUtils {
	
	private DataProvideUtils() {
		
	}
	
	private static List<Map<String, String>> list= new ArrayList<>();
	
	@DataProvider(parallel =true)
	public static Object[] getData(Method m) {
		String testname= m.getName();
		
		if(list.isEmpty()) {
			list=ExcelUtils.getTestDetails(FrameworkConstants.getData());
		}
		
//		List<Map<String, String>> list= ExcelUtils.getTestDetails("DATA");
		
		List<Map<String, String>> smallerlist= new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) && list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smallerlist.add(list.get(i));
				}
			
		}
		
		return smallerlist.toArray(); 
		
	}

}
