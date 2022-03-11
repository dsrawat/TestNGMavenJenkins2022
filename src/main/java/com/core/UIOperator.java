package com.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UIOperator {
	
	
	static String URL;
	
	public static void OpenURL() throws Exception
	{
		 URL=Framework.env.get(Framework.env.get("Run_URL"));
		 try {
			 
			 WebDriverWrapper.getDriver().get(URL);
			 WebDriverWrapper.getDriver().manage().window().maximize();
			 //Framework.extentTestMap.get(UIOperator.getCurrentThreadID()).log(Status.PASS, "Open URL Successfully");
			 Framework.logPass("Open URL Successfully");
		 }
		 catch(Exception e)
		 {
			 Framework.logFail("Failed to Open URL");
		 }
		 
		
	}
	
	public static void click(String ObjectName) throws IOException
	{
		try {
			String values[]=new Framework().readObjectRepository(ObjectName).split("_");
			WebElement ele=add(values);
			ele.click();
			}
			catch(Exception e)
			{
				
				//Framework.Report.addReportStep("Step 5","Description 5","Fail","");
				//Framework.Report.addReportStepError("Unable to Enter Text of "+ObjectName);
			}
		
	}
	
	public static void enterText(String ObjectName,String Value) throws Exception
	{
		try {
			
			
			
		String values[]=new Framework().readObjectRepository(ObjectName).split("_");
		WebElement ele=add(values);
		System.out.println("Values length = "+values.length);
		System.out.println("Values 0 = "+values[0]);
		System.out.println("Values 1 = "+values[1]);
		ele.sendKeys(Value);
		}
		catch(Exception e)
		{
			
			//Framework.logFail("Unable to enter Value in textbox");
			//UIOperator.takeSnapShot();
			Framework.logFail("Unable to enter value");
			Assert.fail("Unable to enter value in Textbox in application");
			
		}
	}
	
	
	public static WebElement add(String values[]) {
		
		WebElement ele=null;
		switch(values[0])
        {
            case "ID":
                ele=WebDriverWrapper.getDriver().findElement(By.id(values[1]));
                break;
            case "Name":
            	//ele=Framework.driver.findElement(By.name(values[1]));
            	ele=WebDriverWrapper.getDriver().findElement(By.name(values[1]));
                break;
            case "ClassName":
            	//ele=Framework.driver.findElement(By.className(values[1]));
                break;
            case "PartialLinkText":
            	//ele=Framework.driver.findElement(By.partialLinkText(values[1]));
                break;
            case "LinkText":
            	//ele=Framework.driver.findElement(By.linkText(values[1]));
                break;
            case "Xpath":
            	//ele=Framework.driver.findElement(By.xpath(values[1]));
                break;
            case "CSS":
            	//ele=Framework.driver.findElement(By.cssSelector(values[1]));
                break;
            default:
                System.out.println("no match");
        }
		
		return ele;
	}
	
	/*
	public synchronized void takeSnapShot(String ClassName,String MethodName) throws Exception{
		System.out.println("HashCode="+WebDriverWrapper.getDriver().hashCode());
		System.out.println("inside screenshot method and current Class is ="+ClassName);
		System.out.println("inside screenshot method and current method is ="+MethodName);
		
		String CName=Thread.currentThread().getStackTrace()[1].getClassName();
		String MName=Thread.currentThread().getStackTrace()[1].getMethodName();
		
		int a=ClassName.lastIndexOf(".");
		String NewClass=ClassName.substring(a+1);
		System.out.println("inside screenshot method and current Class is ="+NewClass);
		//System.out.println("class name ="+new ITestContext().getAllTestMethods()[0].getInstance().getClass())
		String Screenshotname=MethodName+"-"+java.time.LocalDate.now()+"_"+java.time.LocalTime.now().toString().replace(".","").replace(":","");
		WebDriver driver=WebDriverWrapper.getDriver();
		 Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String FileName=Framework.ReportPath+"\\"+NewClass+"\\"+MethodName+"\\"+Screenshotname+".JPEG";
		BufferedImage b=fpScreenshot.getImage();
	    ImageIO.write(b,"JPEG",new File(FileName));
	    
	  
	          
	    //Framework.document.put(Thread.currentThread().getId(), new PDDocument().addPage(page)); 
	      
	      
	      
	      InputStream in = new FileInputStream(new File(FileName));
	      BufferedImage bimg = ImageIO.read(in);
	      
	      float width = bimg.getWidth();
	      float height = bimg.getHeight();
	      PDPage page1 = new PDPage(new PDRectangle(width, height));
	      System.out.println("Framework.document="+Framework.document);
	   //PDDocument doc=new PDDocument();
			//doc.addPage(page1);
	     // Framework.document.addPage(page1); 
	      Framework.document.get(Thread.currentThread().getId()).addPage(page1);
	      //Framework.document.put(Thread.currentThread().getId(), doc);
	      PDImageXObject pdImage1 = PDImageXObject.createFromFile(FileName,Framework.document.get(Thread.currentThread().getId()));
	      PDPageContentStream contentStream = new PDPageContentStream(Framework.document.get(Thread.currentThread().getId()), page1);
	      contentStream.drawImage(pdImage1, 0, 0);
	      bimg.flush();
	      contentStream.close();
	      in.close();

	      System.out.println("Screen="+Framework.ReportPath+"\\"+NewClass+"\\"+MethodName+"\\"+MethodName+"Screens.pdf");
	      Framework.document.get(Thread.currentThread().getId()).save(Framework.ReportPath+"\\"+NewClass+"\\"+MethodName+"\\"+MethodName+"Screens.pdf");
	      //Framework.document.get(Thread.currentThread().getId()).save("");
	      //Framework.document.close();
	      
	      
	      
    }*/
	
	//latest version
	public synchronized static String takeSnapShot() throws Exception {
		System.out.println("HashCode="+WebDriverWrapper.getDriver().hashCode());
		//System.out.println("inside screenshot method and current Class is ="+ClassName);
		//System.out.println("inside screenshot method and current method is ="+MethodName);
		
		String CName=Thread.currentThread().getStackTrace()[3].getClassName();
		String MName=Thread.currentThread().getStackTrace()[3].getMethodName();
		System.out.println("inside screenshot method and current Class is ="+CName);
		System.out.println("inside screenshot method and current method is ="+MName);
		
		for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
		        if(ste.toString().contains("test"))
		    {
		    	System.out.println("Found testclass="+ste.getClassName());
		    	CName= ste.getClassName();
		    	System.out.println("Found testmethod="+ste.getMethodName());
		    	MName= ste.getMethodName();
		    	break;
		    }
		}
		int a=CName.lastIndexOf(".");
		String NewClass=CName.substring(a+1);
		
		System.out.println("inside screenshot method and current Class is ="+NewClass);
		//System.out.println("class name ="+new ITestContext().getAllTestMethods()[0].getInstance().getClass())
		String Screenshotname=MName+"-"+java.time.LocalDate.now()+"_"+java.time.LocalTime.now().toString().replace(".","").replace(":","");
		WebDriver driver=WebDriverWrapper.getDriver();
		 Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String FileName=Framework.ReportPath+"\\"+NewClass+"\\"+MName+"\\"+Screenshotname+".JPEG";
		System.out.println("File name inside snapshot="+FileName);
		BufferedImage b=fpScreenshot.getImage();
	    if(Framework.env.get("GenerateScreenshot").equalsIgnoreCase("Yes"))
	    {
	    	
	    	ImageIO.write(b,"JPEG",new File(FileName));
	    }
	    
	  
	          
	    //Framework.document.put(Thread.currentThread().getId(), new PDDocument().addPage(page)); 
	      
	      
	      
	      InputStream in = new FileInputStream(new File(FileName));
	      BufferedImage bimg = ImageIO.read(in);
	      
	      float width = bimg.getWidth();
	      float height = bimg.getHeight();
	      PDPage page1 = new PDPage(new PDRectangle(width, height));
	      System.out.println("Framework.document="+Framework.document);
	   //PDDocument doc=new PDDocument();
			//doc.addPage(page1);
	     // Framework.document.addPage(page1); 
	      Framework.document.get(Thread.currentThread().getId()).addPage(page1);
	      //Framework.document.put(Thread.currentThread().getId(), doc);
	      PDImageXObject pdImage1 = PDImageXObject.createFromFile(FileName,Framework.document.get(Thread.currentThread().getId()));
	      PDPageContentStream contentStream = new PDPageContentStream(Framework.document.get(Thread.currentThread().getId()), page1);
	      contentStream.drawImage(pdImage1, 0, 0);
	      bimg.flush();
	      contentStream.close();
	      in.close();
	      
	      if(Framework.env.get("GenerateScreenshotPDF").equalsIgnoreCase("Yes"))
	      {
	    	  
	    	  System.out.println("Screen="+Framework.ReportPath+"\\"+NewClass+"\\"+MName+"\\"+MName+"Screens.pdf");
	    	  String  path = Framework.ReportPath+"\\"+NewClass+"\\"+MName+"\\"+MName+"Screens.pdf";
	    	  Framework.document.get(Thread.currentThread().getId()).save(Framework.ReportPath+"\\"+NewClass+"\\"+MName+"\\"+MName+"Screens.pdf");
	      }
	      //Framework.document.get(Thread.currentThread().getId()).save("");
	      //Framework.document.close();
	      return FileName;
	      
	      
    }


	public static synchronized Long getCurrentThreadID()
	{
		System.out.print("Thread ID in method ="+Thread.currentThread().getId());
		Long threadID= Thread.currentThread().getId();
		return threadID;
	}
	
	public static synchronized Thread getCurrentThread()
	{
		return Thread.currentThread();
	}
	
	public static JSONObject readTestDataJson(String JSONFileName) throws IOException, ParseException
	{
		HashMap<String,String> hs=null;
		JSONParser jsonParse= new JSONParser();
		//System.out.println("Test Data File="+System.getProperty("user.dir")+"\\TestData\\TestData.json");
		FileReader fr= new FileReader(System.getProperty("user.dir")+"\\TestData\\"+JSONFileName);
		Object ob= jsonParse.parse(fr);
		System.out.println("before json");
		JSONObject jsob= (JSONObject)ob;
		System.out.println("after json");
		System.out.println("JsonObject="+jsob.get("Job").toString());
		System.out.println("JsonObject="+jsob.get("Name").toString());
		return jsob;
	}
}
