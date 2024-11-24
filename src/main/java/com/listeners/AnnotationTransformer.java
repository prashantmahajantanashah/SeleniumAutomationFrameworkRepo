package com.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		
		if(testMethod.getName().equalsIgnoreCase("test3")) {
			annotation.setEnabled(false);
		}
		HashMap<String, Object> test1= new HashMap<>();
		test1.put("name", "test1");
		test1.put("enabled", true);
		
		HashMap<String, Object> test2= new HashMap<>();
		test2.put("name", "test2");
		test2.put("enabled", false);
		
		HashMap<String, Object> test3= new HashMap<>();
		test3.put("name", "test3");
		test3.put("enabled", true);
		
		
		List<Map<String, Object>> list=new ArrayList<>();
		list.add(test2);
		list.add(test3);
		list.add(test1);//5
		
		
		System.out.println(list);
		
		
		
		for(int i=0;i<list.size();i++) {
			if(testMethod.getName().equalsIgnoreCase(String.valueOf(list.get(i).get("name")))) {
				if(list.get(i).get("enabled").equals(false)) {
					annotation.setEnabled(false);
				} else {
					annotation.setInvocationCount(5);
//					annotation.setRetryAnalyzer(Retry.class);
				}
				
			}
		}
		
		
		
		
		
		
			
		}
	}


	
