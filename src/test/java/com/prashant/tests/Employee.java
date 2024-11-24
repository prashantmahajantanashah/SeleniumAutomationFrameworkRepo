package com.prashant.tests;

import org.testng.annotations.DataProvider;

public class Employee {
	
	private String id;
	private String name;
	
	public Employee(String id, String name){
		this.id=id;
		this.name=name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@DataProvider
	public static Employee[] getData2() {

		Employee[] employees = {
				new Employee("1","shubham"),
				new Employee("2","prashant")
		};
		
		return employees;

	}
	
	

}
