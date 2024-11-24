package com.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class EnumRunner {
	
	public static void main(String[] args) {
		
		//java compiler by default adds a toString
		System.out.println(Severity.CRITICAL);
		
		Severity sev = Severity.CRITICAL;
		
		switch (sev) {
		case CRITICAL:
			System.out.println("CRITICAL");
			break;
		case MAJOR:
			System.out.println("MAJOr");
			break;
		}
		// valueOf method is used to convert string to an enum
		Severity.valueOf("CRITICAL");
		System.out.println(Severity.valueOf("CRITICAL"));
		System.out.println("*******");
		
		Severity[] arr=Severity.values();
		
		Arrays.asList(arr).forEach(e-> System.out.println(e));
		
		Arrays.asList(arr).forEach(System.out::println);
		
		//can be done using hashset but enumset is the proper way of doig it
		EnumSet<Severity> enumset = EnumSet.of(Severity.CRITICAL,Severity.MAJOR);
		
		System.out.println("*******");
		
		enumset.forEach(System.out::println);
		
		System.out.println("*******");
		
		Map<Severity,String> map =new HashMap();
		map.put(Severity.CRITICAL, "critical");
		map.put(Severity.MAJOR, "major");
		
		
		System.out.println("*******");
		
		EnumMap<Severity,String> map1 =new EnumMap<>(Severity.class);
		map1.put(Severity.CRITICAL, "critical");
		map1.put(Severity.MAJOR, "major");
		
		map1.forEach((k,v)-> System.out.println(k));
		
		
		Severity.MAJOR.getFixingHours();
		
		
		
		
	}

}
