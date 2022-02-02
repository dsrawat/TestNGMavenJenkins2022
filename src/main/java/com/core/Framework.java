package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Framework {

	public static WebDriverWrapper driverWrapper;
	private static WebDriver driver;
	public static HashMap<String,String> env=new HashMap<String,String>();
	public static ExtentManager Report=new ExtentManager();
	public static HashMap<String,String> Data=new HashMap<String,String>();
	public static String ReportPath="";
	public static String currentMethodName;
	public static String currentClassName;
	public static HashMap <Long,PDDocument>  document=new HashMap<Long,PDDocument>();
	public static ExtentReports extent;
	public static HashMap <Long,ExtentTest>extentTestMap = new HashMap<Long,ExtentTest>();
	HSSFWorkbook wb;
	HSSFSheet sh;
	
	
	public static void startDriver(String browser) throws IOException
	{
		System.out.println("StartDriver - Begin");
		driverWrapper=new WebDriverWrapper();
		//driver=driverWrapper.initializeDriver(env.get("BrowserType"),env.get("DriverPath"));
		WebDriverWrapper.initializeDriver(browser,env.get("DriverPath"));
		initializeRepository();
		System.out.println("StartDriver - End");
	}
	
	public static void collectEnvironmentData() throws IOException{
		
		//Load Properties File
				String PathToConfigFile=System.getProperty("user.dir");
				System.out.println(PathToConfigFile);
				Properties prop=new Properties();
				FileInputStream fp=new FileInputStream(new File(PathToConfigFile+"\\Config\\Environment.prop"));
				prop.load(fp);
				
				Enumeration em = prop.keys();
				  while(em.hasMoreElements()){
				  String key = (String)em.nextElement();
				  //String Value=prop.get(key).toString();
				  String Value=prop.getProperty(key);
				  env.put(key, Value);
				  }
				  System.out.println("env="+env);
	}
	
	public static void initializeRepository() throws IOException
	{
		
		
		//System.out.println("checking="+sh.getLastRowNum());
		
		
	}
	
	public String readObjectRepository(String ObjectName) throws IOException
	{
		HashMap<String,String> hs=null;
		FileInputStream File=new FileInputStream(new File(Framework.env.get("RepositoryPath")));
		//Workbook wb=new XSSFWorkbook();
		System.out.println("repo="+Framework.env.get("RepositoryPath"));
		wb = new  HSSFWorkbook(File);
		sh=wb.getSheetAt(0);
		int rowcount=sh.getLastRowNum();
		int colcount=sh.getRow(1).getLastCellNum();
		System.out.println("Row Count="+rowcount);
		System.out.println("Column Count="+colcount);
		String objectname1;
		String ObjectValue="";
		String PropertyName="";
		String PropertyValue="";
		hs=new HashMap<String,String>();
		for(int i=1;i<=rowcount;i++)
		{
			objectname1=sh.getRow(i).getCell(0).toString();
			if(objectname1.equalsIgnoreCase(ObjectName))
			{
				
				
				
				
				
				for(int j=1;j<colcount;j++)
				{
					
					if(!sh.getRow(i).getCell(j).toString().equals(""))
					{
						PropertyName=sh.getRow(0).getCell(j).toString();
						PropertyValue=sh.getRow(i).getCell(j).toString();
					}
					//hs.put(sh.getRow(0).getCell(j).toString(), );
					
					/*System.out.println("Column value"+sh.getRow(i).getCell(j));
					ObjectValue=sh.getRow(i).getCell(j).toString();
					if(ObjectValue.isEmpty())
						continue;
					else
					{
						break;
					}*/
				}
				
				System.out.println("hashmap value="+hs);
			}
			if(!ObjectValue.isEmpty())
				break;
		}
		String MatchingType="";
		switch(PropertyName)
        {
            case "ID":
                System.out.println("ID Matched");
                MatchingType="ID";
                break;
            case "Name":
                System.out.println("two");
                MatchingType="Name";
                break;
            case "ClassName":
                System.out.println("three");
                MatchingType="ClassName";
                break;
            case "PartialLinkText":
            	MatchingType="PartialLinkText";
                break;
            case "LinkText":
            	MatchingType="LinkText";
                break;
            case "Xpath":
            	MatchingType="Xpath";
                break;
            case "CSS":
            	MatchingType="CSS";
                break;
            default:
                System.out.println("no match");
        }
		
		return MatchingType+"_"+PropertyValue;
	}
	
	
	
	
	
	//Read Test Data from Excel
	public static HashMap<String,String> readTestData(String Heading) throws IOException
	{
		
		HashMap<String,String> hs=null;
		HSSFWorkbook wb;
		HSSFSheet sh;
		FileInputStream File=new FileInputStream(new File(Framework.env.get("TestData")));
		//Workbook wb=new XSSFWorkbook();
		//System.out.println("repo="+Framework.env.get("RepositoryPath"));
		wb = new  HSSFWorkbook(File);
		sh=wb.getSheetAt(0);
		int rowcount=sh.getLastRowNum();
		int colcount=sh.getRow(1).getLastCellNum();
		//System.out.println("Row Count data="+rowcount);
		//System.out.println("Column Count data="+colcount);
		int matchedrow=0;
		for(int k=0;k<rowcount;k++)
		{
			
			 Row row = sh.getRow(k);
			 if(row!=null)
			 {
			 
			 //System.out.println("Cell value="+sh.getRow(k).getCell(0).toString());
				 	if(sh.getRow(k).getCell(0).toString().equalsIgnoreCase(Heading))
				 		{	
				 			matchedrow=k;
				 			break;
				 		}
			 }
			 	
		}
		
		//System.out.println("MatchedRow="+matchedrow);
		colcount=sh.getRow(matchedrow+1).getLastCellNum();
		//System.out.println("cell count="+colcount);
		for(int i=matchedrow+2;i<=(matchedrow+2);i++)
		{
			for(int j=0;j<colcount;j++)
			{
				String Headin=sh.getRow(i-1).getCell(j).toString();
				String Value=sh.getRow(i).getCell(j).toString();
				
				//System.out.println("Heading ="+sh.getRow(i-1).getCell(j).toString());
				//System.out.print(" Value ="+sh.getRow(i).getCell(j).toString());
				
				Data.put(Headin,Value);
			}
		}
		
		System.out.println("Data="+Data);
		
		return Data;
		
		
		
		
	}
	
}
