package TestNGFramework.TestNGMavenGitJenkins;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.core.BaseClass;
import com.core.Framework;
import com.core.Reporter;
import com.core.UIOperator;
import com.dependentMethods.ProjectSpecificMethods;

import org.testng.asserts.Assertion;


public class Test1 extends BaseClass{
	//Framework framework=new Framework();
	//Logger Log=null;
	
	
	Logger Log=Logger.getLogger(Test1.class);
	
	
	
	@Test(groups= {"SmokeTest"})
	public void test11() throws Exception
	
	{
		//Long CurrentThread=Thread.currentThread().getId();
		Long CurrentThread = UIOperator.getCurrentThreadID();
		Log.debug("************************test1 execution Start*********************************************");
		System.out.println("test1 Thread ID= " + CurrentThread);
		//System.out.println("browser="+browser);
		//HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		JSONObject jsob = UIOperator.readTestDataJson("TestData.json");
		System.out.println("inside Test JsonObject="+jsob.get("Job").toString());
		System.out.println("inside Test JsonObject="+jsob.get("Name").toString());
		UIOperator.OpenURL();
		Framework.extentTestMap.get(UIOperator.getCurrentThreadID()).log(Status.PASS, "Open URL not Successfully");
		System.out.println("test1 Thread ID= " + CurrentThread);
		//Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Open URL Successfully");
		//System.out.println("className="+UIOperator.getCurrentThread().getStackTrace()[1].getClassName());
		//System.out.println("Method Name="+UIOperator.getCurrentThread().getStackTrace()[1].getMethodName());
		//new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		UIOperator.takeSnapShot();
		Thread.sleep(5000);
		System.out.println("test1 Thread ID= " + Thread.currentThread().getId());
		//Framework.Report.addReportStep("Step 1","Description 1","Pass","");
		Assert.assertEquals(true, true);
		//Log.debug("************************test1 execution Complete*************************************************");
		//Framework.Report.addReportStep("Step 2","Description 2","Fail","");
		//Framework.Report.addReportStep("Step 3","Description 3","Pass","");
		System.out.println("test1 Thread ID= " + Thread.currentThread().getId());
		System.out.println("ending of test1()");
		 
	}
	
		
	@Test(groups= {"SmokeTest"})
	public void test12() throws Exception
	
	{
		//Long CurrentThread=Thread.currentThread().getId();
		Long CurrentThread = UIOperator.getCurrentThreadID();
		Log.debug("************************test1 execution Start*********************************************");
		System.out.println("test1 Thread ID= " + CurrentThread);
		//System.out.println("browser="+browser);
		//HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		
		UIOperator.OpenURL();
		Framework.extentTestMap.get(UIOperator.getCurrentThreadID()).log(Status.PASS, "test12 open URL not successfull");
		System.out.println("test1 Thread ID= " + CurrentThread);
		//Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Open URL Successfully");
		//System.out.println("className="+UIOperator.getCurrentThread().getStackTrace()[1].getClassName());
		//System.out.println("Method Name="+UIOperator.getCurrentThread().getStackTrace()[1].getMethodName());
		//new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		UIOperator.takeSnapShot();
		Thread.sleep(5000);
		System.out.println("test1 Thread ID= " + Thread.currentThread().getId());
		//Framework.Report.addReportStep("Step 1","Description 1","Pass","");
		Assert.assertEquals(true, true);
		//Log.debug("************************test1 execution Complete*************************************************");
		//Framework.Report.addReportStep("Step 2","Description 2","Fail","");
		//Framework.Report.addReportStep("Step 3","Description 3","Pass","");
		System.out.println("test1 Thread ID= " + Thread.currentThread().getId());
		System.out.println("ending of test1()");
		 
	}
	
	
	@Test(groups= {"sanity"})
	public void testpractice() throws Exception
	{
		System.out.println("test2 Thread ID= " + Thread.currentThread().getId());
		UIOperator.OpenURL();
		//UIOperator.takeSnapShot();
		System.out.println("test2 Thread ID= " + Thread.currentThread().getId());
		
	}
	
	

}
