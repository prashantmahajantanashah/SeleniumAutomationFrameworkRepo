package com.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.prashant.constants.FrameworkConstants;
import com.prashant.utils.ExcelUtils;

public class MethodInterceptorListener implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> result = new ArrayList<>();

		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanager());

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < methods.size(); j++) {
				if (list.get(i).get("testname").equalsIgnoreCase(methods.get(j).getMethod().getMethodName()) && 
						list.get(i).get("execute").equalsIgnoreCase("yes")) {
						System.out.println(list.get(i).get("testdescription"));
						methods.get(j).getMethod().setDescription(list.get(i).get("testdescription"));
						methods.get(j).getMethod().setInvocationCount(Integer.parseInt(list.get(i).get("count")));
						result.add(methods.get(j));

					}
				
			}

		}
		return result;
	}
}
