package com.listeners;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Runner {

	@BeforeSuite
	public void setupSuite() {	
		//initialise db connection
		//init the extent reports
		System.out.println("before suite in runner");}

	@AfterSuite
	public void tearDownSuite() {System.out.println("after suite in runner");}

	@BeforeMethod
	public void setUp() {System.out.println("before method in runner");}

	@AfterMethod
	public void tearDown() {System.out.println("after method in runner");}

	@Test
	public void test1() {System.out.println("test1");
	assertFalse(true);}

	@Test
	public void test2() {System.out.println("test2");}

	@Test
	public void test3() {System.out.println("test3");}

}
