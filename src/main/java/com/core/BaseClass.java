package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseClass implements IRetryAnalyzer  {
	
	static String var=null;
	static String var1=null;
	String optbrowser="firefox";
	int counter=0;
	@BeforeSuite(alwaysRun=true)
	public void setUP() throws IOException 
	{
		
		System.out.println("----------------Before Suite - Start----------BaseClass - setUP------------");
		FileInputStream file=null;
		try {
			file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Logs\\Log4j.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PropertyConfigurator.configure(file);
		//Log=Logger.getLogger(Test1.class);
		try {
			Framework.collectEnvironmentData();
			Framework.extent=ExtentManager.getInstance();
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("----------------Before Suite - End-----------BaseClass - setUP------------------");
		
	}
	
	@BeforeClass(alwaysRun=true)
	public void createClassDirectory()
	{
		System.out.println("----------------before Class - Start------BaseClass - createClassDirectory----------");
		System.out.println("Name of the class"+this.getClass().getSimpleName());
		
		Framework.currentClassName=this.getClass().getSimpleName();
		System.out.println(System.getProperty("user.dir")+this.getClass().getSimpleName());
		File file = new File(Framework.ReportPath+"\\"+this.getClass().getSimpleName());
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        System.out.println("----------------Before Class - End-------BaseClass - createClassDirectory---------");
		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void cretePDFDocument() throws IOException
	{
		System.out.println("----------------Before Test - Start------BaseClass - cretePDFDocument----------");
		
		//Framework.startDriver(browser);
		System.out.println("Thread in PDF Document="+Thread.currentThread().getId());
		Long t=Thread.currentThread().getId();
		PDDocument doc=new PDDocument();
		Framework.document.put(t, doc);
		//System.out.println("Thread value="+Framework.document.get(Thread.currentThread().getId()));
		//System.out.println("After report initialize Thread number="+Thread.currentThread().getId());
		System.out.println("----------------Before Test - End-------BaseClass - cretePDFDocument---------");
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public void browserFactory() throws IOException
	{
		System.out.println("----------------Before Test - Start------BaseClass - browserFactory----------");
		
		//Framework.startDriver(browser);
		System.out.println("app.broswer = "+App.browser);
		Framework.startDriver(App.browser);
		
		System.out.println("----------------Before Test - End-------BaseClass - browserFactory---------");
	}
	
	@AfterMethod(alwaysRun=true)
	public void quitAfterEachTest() throws IOException
	{
		System.out.println("----------------After Test - Start-------BaseClass - quitAfterEachTest---------");
		
		WebDriverWrapper.getDriver().quit();
	
		System.out.println("----------------After Test - End---------BaseClass - quitAfterEachTest-------");
		
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public void createTestDirectory(Method result) throws IOException
	{
		System.out.println("----------------Before Method - Start--------BaseClass - createTestDirectory--------");
		System.out.println("inside setTestData method to create test folder");
		System.out.println("curent execute Test Method="+result.getName());
		Framework.currentMethodName=result.getName();	
		System.out.println("Full path for creating test folder="+Framework.ReportPath+"\\"+this.getClass().getSimpleName()+"\\"+Framework.currentMethodName);
		File file = new File(Framework.ReportPath+"\\"+this.getClass().getSimpleName()+"\\"+Framework.currentMethodName);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

		Framework.Data=Framework.readTestData(result.getName());
		
		System.out.println("----------------Before Method - End-------BaseClass - createTestDirectory---------");
		
		
	}
	
	/*
	@BeforeMethod(alwaysRun=true)
	public void setTestData(Method result) throws IOException
	{
		

		//Framework.Data=Framework.readTestData(result.getName());
		
		System.out.println("----------------Before Method - End-------setTestData---------");
		
		
	}*/
	
	@AfterMethod(alwaysRun=true)
	public void setReportData(Method result) throws IOException
	{
		System.out.println("----------------After Method - Start-------BaseClass - setReportData---------");
		System.out.println("curent execute Test Method="+result.getName());
		Framework.Data=Framework.readTestData(result.getName());
		Framework.document.get(Thread.currentThread().getId()).close();
		System.out.println("----------------After Method - End-------BaseClass - setReportData---------");
	}

	@Override
	public boolean retry(ITestResult result) {
		
		int retryLimit = Integer.parseInt(Framework.env.get("RetryLimit"));
		
		System.out.println("retryLimit="+retryLimit);
		if (!result.isSuccess()) {
			System.out.println("counter value="+counter);
			 if(counter < retryLimit){
				 counter++;
			 return true;
			 }
			 }
			 return false;
			 
	}

	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() throws IOException
	{
		System.out.println("----------------After Suite - Start----------------");
		
		
		System.out.println("----------------After Suite - End-------------------");
	}
	

}
