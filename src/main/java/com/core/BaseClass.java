package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	static String var=null;
	static String var1=null;
	String optbrowser="firefox";
	
	@BeforeSuite(alwaysRun=true)
	public void beforSuite() throws IOException 
	{
		
		System.out.println("Before Suite - Start ");
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
			//Log.debug("************************Collecting Envirnonment Data*************************************************");
			/*var=System.getProperty("user.dir")+"\\"+"Report";
			System.out.println(var);
			File file1 = new File(var);
	        if (!file1.exists()) {
	            if (file1.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
			
	        }	
	        
	        
	        var1=var+"\\"+"Report"+java.time.LocalDate.now()+"_"+java.time.LocalTime.now().toString().replace(".","").replace(":","");
			System.out.println(var1);
			Framework.ReportPath=var1;
			File file2 = new File(var1);
	        if (!file2.exists()) {
	            if (file2.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
			
	        }*/	
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Framework.extent=ExtentManager.getInstance();
		//ExtentManager.initializeReport();
		System.out.println("Before Suite - End ");
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() throws IOException
	{
		System.out.println("After Suite - Start");
		
		//Log.debug("************************Browser Closed*************************************************");
		//Framework.driver.quit();
		//ExtentManager.writeReporter();
		//Framework.Report.getInstance().flush();
		
		System.out.println("After Suite - End");
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void beforeTest(@Optional("firefox") String browser) throws IOException
	{
		System.out.println("Before Test - Start");
		//System.out.println("Hello="+Thread.currentThread().getStackTrace()[1].getClassName());
		//.out.println("Hello1="+Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.startDriver(browser);
		System.out.println("Thread in PDF Document="+Thread.currentThread().getId());
		Long t=Thread.currentThread().getId();
		PDDocument doc=new PDDocument();
		//doc.addPage(new PDPage());
		//doc.save(Framework.ReportPath+"\\"+"Screens"+Math.random()+".pdf");
		Framework.document.put(t, doc);
		
		System.out.println("Thread value="+Framework.document.get(Thread.currentThread().getId()));
		//Framework.document = new PDDocument();
		//Framework.Report.createInstance();
		//Framework.Report.createInstance();
		System.out.println("After report initialize Thread number="+Thread.currentThread().getId());
		//ExtentManager.startReport();
		//WebDriverWrapper.getDriver().get(url);
		//framework.driver.quit();
		//Log.debug("************************Browser Closed*************************************************");
		
		System.out.println("Before Test - End");
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterTest() throws IOException
	{
		System.out.println("After Test - Start");
		//framework.startDriver();
		//Framework.driver.close();
		//Framework.driver.quit();
		//Framework.Report.getInstance().flush();
		WebDriverWrapper.getDriver().quit();
		//Log.debug("************************Browser Closed*************************************************");
		System.out.println("After Test - End");
		
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeclass()
	{
		System.out.println("before Class - Start");
		System.out.println("Name of the class"+this.getClass().getSimpleName());
		//String folderpath=;
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
        System.out.println("Before Class - End");
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setTestData(Method result) throws IOException
	{
		System.out.println("Before Method - Start");
		System.out.println("inside setTestData method to create test folder");
		System.out.println("curent execute Test Method="+result.getName());
		Framework.currentMethodName=result.getName();
		//Framework.document = new PDDocument();
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
		//Framework.Report.addScenario(result.getName());
		//Framework.Report.getExtentTestInstance(Framework.currentMethodName);
		System.out.println("Before Method - End");
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void setReportData(Method result) throws IOException
	{
		System.out.println("After Method - Start");
		System.out.println("curent execute Test Method="+result.getName());
		Framework.Data=Framework.readTestData(result.getName());
		//Framework.Report.endScenario();
		Framework.document.get(Thread.currentThread().getId()).close();
		System.out.println("After Method - End");
	}
	
	

}
