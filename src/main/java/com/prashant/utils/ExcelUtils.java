package com.prashant.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IMethodInstance;

import com.google.common.collect.Table.Cell;
import com.prashant.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetname) {
		List<Map<String, String>> list = new ArrayList<>();
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelpath());

			XSSFWorkbook workbook = new XSSFWorkbook(fs);

			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastRowNum = sheet.getLastRowNum();
			System.out.println(lastRowNum);
			int lastColumnNum = sheet.getRow(0).getLastCellNum();
			System.out.println(lastColumnNum);
			Map<String, String> map;

			list = new ArrayList<>();

			for (int i = 1; i <= lastRowNum; i++) {
				map = new HashedMap<>();
				for (int j = 0; j < lastColumnNum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(key + ": " + value);
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (Objects.nonNull(fs)) {
					fs.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

}
