package com.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.prashant.annotations.FrameworkAnnotation;
import com.prashant.reports.ExtentLogger;
import com.prashant.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthorToTest(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategoryToTest(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() +" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() +" is failed");
		ExtentLogger.fail(result.getThrowable().toString());//for first error log
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		System.out.println(result.getMethod().getMethodName() +" is skipped");
		ExtentLogger.skip(result.getMethod() + " is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		// not gonna user
		/*we are having justr one test in suite so we dont have any special implementation
		 * */
	}

	@Override
	public void onFinish(ITestContext context) {
		// not gonna use
		/*we are having justr one test in suite so we dont have any special implementation
		 * */
	}
	
	

}
