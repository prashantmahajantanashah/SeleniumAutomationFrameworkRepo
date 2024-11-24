package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.prashant.enums.ConfigProperties;
import com.prashant.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {
	int count = 0;
	int maxRetryCount = 1;

	// Whenever a test is failed, this method retry will be called ,
	// if this method returns true the failed method will be retried
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value=count<maxRetryCount;
			count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

//	public boolean retry(ITestResult result) {
//
//		if (count < maxRetryCount) {
//			count++;
//			return true;
//		}
//		return false;
//	}

}
