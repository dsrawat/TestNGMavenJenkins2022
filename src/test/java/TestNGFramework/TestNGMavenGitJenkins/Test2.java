package TestNGFramework.TestNGMavenGitJenkins;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.core.BaseClass;
import com.core.Framework;
import com.core.UIOperator;

public class Test2 extends BaseClass {
	
	Logger Log=Logger.getLogger(Test2.class);
	
	
	
	@Test(groups= {"SmokeTest"})
	public void test3() throws Exception
	{
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		
		Long CurrentThread=Thread.currentThread().getId();
		Log.debug("************************test3 execution Start*********************************************");
		UIOperator.OpenURL();
		
		
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Open URL Successfully");
		/*UIOperator.enterText("FirstName",Framework.Data.get("FirstName"));
		
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Name Successfully");
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		UIOperator.enterText("lastname",Framework.Data.get("lastname"));
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Last Name Successfully");
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		UIOperator.enterText("phone",Framework.Data.get("phone"));
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Phone number Successfully");
		UIOperator.enterText("EmailID",Framework.Data.get("EmailID"));
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Email Successfully");
		UIOperator.enterText("address",Framework.Data.get("address"));
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Address Successfully");
		UIOperator.enterText("city",Framework.Data.get("city"));
		UIOperator.enterText("state",Framework.Data.get("state"));
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter State Successfully");
		UIOperator.enterText("username",Framework.Data.get("username"));
		UIOperator.enterText("password",Framework.Data.get("password"));
		UIOperator.enterText("confirmpassword",Framework.Data.get("confirmpassword"));
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter username and password Successfully");
		UIOperator.click("submitbtn");
		//UIOperator.takeSnapShot();
		Thread.sleep(5000);*/
		//UIOperator.takeSnapShot();
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		//Framework.Report.addReportStep("Step 1","Description 1","","");
		UIOperator.enterText("GoogleSearch_TextBox","Selenium");
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		Thread.sleep(5000);
		//UIOperator.takeSnapShot();
		Assert.assertEquals(true, true);
		//Framework.Report.addReportStep("Step 2","Description 2","","");
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		//UIOperator.takeSnapShot();
		Log.debug("************************test3 execution Complete*************************************************");
		
	}
	
	@Test(groups= {"SmokeTest"})
	public void test4() throws Exception
	{
		Long CurrentThread=Thread.currentThread().getId();
		Log.debug("************************test4 execution Start*********************************************");
		UIOperator.OpenURL();
		
		
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Open URL Successfully");
		/*UIOperator.enterText("FirstName",Framework.Data.get("FirstName"));
		
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Name Successfully");
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		UIOperator.enterText("lastname",Framework.Data.get("lastname"));
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Last Name Successfully");
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		UIOperator.enterText("phone",Framework.Data.get("phone"));
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Phone number Successfully");
		UIOperator.enterText("EmailID",Framework.Data.get("EmailID"));
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Email Successfully");
		UIOperator.enterText("address",Framework.Data.get("address"));
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter Address Successfully");
		UIOperator.enterText("city",Framework.Data.get("city"));
		UIOperator.enterText("state",Framework.Data.get("state"));
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter State Successfully");
		UIOperator.enterText("username",Framework.Data.get("username"));
		UIOperator.enterText("password",Framework.Data.get("password"));
		UIOperator.enterText("confirmpassword",Framework.Data.get("confirmpassword"));
		new UIOperator().takeSnapShot(Thread.currentThread().getStackTrace()[1].getClassName(),Thread.currentThread().getStackTrace()[1].getMethodName());
		Framework.extentTestMap.get(CurrentThread).log(Status.PASS, "Enter username and password Successfully");
		UIOperator.click("submitbtn");
		//UIOperator.takeSnapShot();
		Thread.sleep(5000);*/
		//UIOperator.takeSnapShot();
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
		//Framework.Report.addReportStep("Step 1","Description 1","","");
		UIOperator.enterText("GoogleSearch_TextBox","Selenium");
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
		Thread.sleep(5000);
		//UIOperator.takeSnapShot();
		Assert.assertEquals(true, true);
		
		//Framework.Report.addReportStep("test4 Step ","Description ","","");
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
		Log.debug("************************test4 execution Complete*************************************************");
	}
	
	@Test(groups= {"sanity"})
	public void test5() throws Exception
	{
		System.out.println("test Thread ID= " + Thread.currentThread().getId());
		UIOperator.OpenURL();
		//UIOperator.takeSnapShot();
		System.out.println("test Thread ID= " + Thread.currentThread().getId());
		
	}

}
