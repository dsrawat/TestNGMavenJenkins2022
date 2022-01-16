package com.core;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

public class GenerateReport  implements ITestListener {
	private static ExtentReports extent = ExtentManager.createInstance();
	
	//private static Map extentTestMap = new HashMap();

	public static synchronized ExtentTest getTest() {
        return Framework.extentTestMap.get((long) (Thread.currentThread().getId()));
    }
 
    public static synchronized ExtentTest startTest(String testName, String desc) {
    	System.out.println("Inside Start Test listerner");
        ExtentTest test = extent.createTest(testName, desc);
        Framework.extentTestMap.put( (long) (Thread.currentThread().getId()), test);
        System.out.println("Extent Map="+Framework.extentTestMap);
        return test;
    }
	
	@Override
	public synchronized void onStart(ITestContext context) {
		
		System.out.println("OnStart Invoked...." +    context.getAllTestMethods()[0].getInstance().getClass());
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		startTest(result.getMethod().getMethodName(),"");
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		getTest().pass("TestCase Pass");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
        MediaEntityModelProvider mediaModel;
        //getTest().pass("TestCase Fail");
		/*try {
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build();
			getTest().fail(result.getThrowable(), mediaModel);
		} catch (IOException e) {
			getTest().fail(result.getThrowable());
		}*/
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		getTest().skip(result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
}
