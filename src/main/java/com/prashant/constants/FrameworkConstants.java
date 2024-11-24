package com.prashant.constants;

import com.prashant.enums.ConfigProperties;
import com.prashant.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+ "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH+ "/chromedriver.exe";
	private static final String CONFIGPATH = RESOURCESPATH + "/config/config.properties";
	private static final int EXPLICITWAIT = 10;
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+ "/extent-test-output";
	private static String extentReportFilePath= "";
	private static final String EXCELPATH= RESOURCESPATH+ "/excel/IMethodDemo.xlsx";
	private static final String RUNMANAGER= "RUNMANAGER";
	private static final String DATA= "DATA";
	
	
	public static String getRunmanager() {
		return RUNMANAGER;
	}

	public static String getData() {
		return DATA;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath =createExtentReportFilePath();
		}
		return extentReportFilePath;
	}

	private static String createExtentReportFilePath() throws Exception {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("no")){
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
		} 
		else{
			return EXTENTREPORTFOLDERPATH + "/"  + "index.html";
		}
		
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigPFilePath() {
		return CONFIGPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	private FrameworkConstants(){
		
	}
	
	

}
