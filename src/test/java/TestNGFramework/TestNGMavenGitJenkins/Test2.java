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


public class Test2 extends BaseClass{
	//Framework framework=new Framework();
	//Logger Log=null;
	
	
	Logger Log=Logger.getLogger(Test2.class);
	
	
	
	@Test(groups= {"SmokeTest1234"})
	public void test21() throws Exception
	{
		
		Long CurrentThread = UIOperator.getCurrentThreadID();
		Log.debug("************************test1 execution Start*********************************************");
		//System.out.println("test1 Thread ID= " + CurrentThread);
		//System.out.println("browser="+browser);
		//HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		JSONObject jsob = UIOperator.readTestDataJson("TestData.json");
		System.out.println("inside Test JsonObject="+jsob.get("Job").toString());
		System.out.println("inside Test JsonObject="+jsob.get("Name").toString());
		UIOperator.OpenURL();
		UIOperator.enterText1("GoogleSearch_TextBox", jsob.get("SearchData").toString());
		
		UIOperator.takeSnapShot();
		
		System.out.println("ending of test1()");
		 
	}
	
	@Test(groups= {"SmokeTest1234"})
	public void test22() throws Exception
	{
		
		Long CurrentThread = UIOperator.getCurrentThreadID();
		Log.debug("************************test1 execution Start*********************************************");
		//System.out.println("test1 Thread ID= " + CurrentThread);
		//System.out.println("browser="+browser);
		//HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		JSONObject jsob = UIOperator.readTestDataJson("TestData.json");
		System.out.println("inside Test JsonObject="+jsob.get("Job").toString());
		System.out.println("inside Test JsonObject="+jsob.get("Name").toString());
		UIOperator.OpenURL();
		UIOperator.enterText1("GoogleSearch_TextBox", jsob.get("SearchData").toString());
		
		UIOperator.takeSnapShot();
		
		System.out.println("ending of test1()");
		 
	}
	
	@Test(groups= {"SmokeTest1234"})
	public void test23() throws Exception
	{
		
		Long CurrentThread = UIOperator.getCurrentThreadID();
		Log.debug("************************test1 execution Start*********************************************");
		//System.out.println("test1 Thread ID= " + CurrentThread);
		//System.out.println("browser="+browser);
		//HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		JSONObject jsob = UIOperator.readTestDataJson("TestData.json");
		System.out.println("inside Test JsonObject="+jsob.get("Job").toString());
		System.out.println("inside Test JsonObject="+jsob.get("Name").toString());
		UIOperator.OpenURL();
		UIOperator.enterText1("GoogleSearch_TextBox", jsob.get("SearchData").toString());
		
		UIOperator.takeSnapShot();
		
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
