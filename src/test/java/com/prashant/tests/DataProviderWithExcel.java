package com.prashant.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {

	@Test(dataProvider = "getData1")
	public void test1(Map<String,String> map) {

		System.out.println(map.get("fname"));

	}
	
	
	@DataProvider
	public Object[] getData1() throws IOException {
		FileInputStream fis = new FileInputStream("/Users/pmahaja2/Downloads/wowmomos.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("testing");

		int rowNum = sheet.getLastRowNum(); 

		int columnNum = sheet.getRow(0).getLastCellNum();
		
		Object[] data=new Object[rowNum];
		
		Map<String, String> map;

		
		for (int i = 1; i <= rowNum; i++) {
			map=new HashMap<>();
			for (int j = 0; j < columnNum; j++) {
				String key =sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			data[i-1]=map;
			
		}

		return data;

	}

	
	public Object[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream("/Users/pmahaja2/Downloads/wowmomos.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("testing");

		int rowNum = sheet.getLastRowNum(); 
		System.out.println(rowNum);//4 when there are 5 rows
		int columnNum = sheet.getRow(0).getLastCellNum();
		System.out.println(columnNum);//4
		Object[][] data = new Object[rowNum][columnNum];
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return data;

	}

}
