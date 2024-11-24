package com.prashant.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "getData1")
	public void test1(Employee emp) {
		System.out.println("trending bike is: " + emp.getId());
		System.out.println("entering username");
		System.out.println("entering password");
		System.out.println("login");
		Assert.assertFalse(false);
		

	}
	
	@Test(dataProvider = "getData1")
	public void test2(String username) {
		System.out.println("new test" +username);
		System.out.println("new test 2");
	}
	
	
	
	@DataProvider
	public Object[] getData1(Method m) {
		if(m.getName().equalsIgnoreCase("test2")) {
			String[] bikes = {
					"cbr150",
					"yamaha",
					"ronnin"
			};
					return bikes;
			}
		else if(m.getName().equalsIgnoreCase("test1")){
			Employee[] employees = {
					new Employee("1","shubham"),
					new Employee("2","prashant")
			};
			
			return employees;
		} else {
			return null;
		}
			
		}
	}
	
	
	
	/*
	 * 2d object array is not always the return type of data provider
	 * Object[][] -> first dim indicates how many iteration you want test to run
	 * Second dimention means how many parameters you want to feed your test data
	 * If you want to pass single parameter, you can use single String[] array
	 * If you want to pass different data types then you can use Object[] as it is super class of all objects
	 * You can also pass custom class objects
	 * */



