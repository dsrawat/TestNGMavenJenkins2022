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
import com.core.ExtentManager;
import com.core.Framework;
import com.core.Reporter;
import com.core.UIOperator;
import com.core.WebDriverWrapper;
import com.dependentMethods.ProjectSpecificMethods;

import org.testng.asserts.Assertion;


public class Test5 extends BaseClass{
	//Framework framework=new Framework();
	//Logger Log=null;
	
	
	
	
	
	
	@Test(groups= {"SmokeTest"})
	public void test1() throws Exception
	{
		System.out.println("Start HashCode="+WebDriverWrapper.getDriver().hashCode());
		System.out.println("Dharam test1");
		Long CurrentThread = UIOperator.getCurrentThreadID();
		
		UIOperator.OpenURL();
		//Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Open URL Successfully");
		//ExtentManager.getInstance().
		System.out.println("End HashCode="+WebDriverWrapper.getDriver().hashCode());
	}
		 
	
	@Test(groups= {"SmokeTest"})
	public void test2() throws Exception
	{
		System.out.println("Start HashCode="+WebDriverWrapper.getDriver().hashCode());
		System.out.println("Dharam test1");
		Long CurrentThread = UIOperator.getCurrentThreadID();
		
		UIOperator.OpenURL();
		//Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Open URL Successfully");
		//ExtentManager.getInstance().
		System.out.println("End HashCode="+WebDriverWrapper.getDriver().hashCode());
	} 
	
	
	
	
	
	

}
