package com.prashant.tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestClass {
	
	@Test(description="dummy test description")
	public void dummytest(Method m) {
		
		System.out.println(m.getAnnotation(Test.class).description());
		
	}

}
