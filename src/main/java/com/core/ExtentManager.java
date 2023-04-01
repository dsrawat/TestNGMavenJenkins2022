package com.core;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
 
    
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public static ExtentReports getInstance() {
        if (Framework.extent == null)
            Framework.extent=createInstance();
        return Framework.extent;
    }
 
    public static ExtentReports createInstance() {
    	
    	System.out.println("Generate report calling createInstance");
    	
    	
    	String var=System.getProperty("user.dir")+"\\"+"Report";
		System.out.println(var);
		File file1 = new File(var);
        if (!file1.exists()) {
            if (file1.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
		
        }	
        
        
        String var1=var+"\\"+"Report"+java.time.LocalDate.now()+"_"+java.time.LocalTime.now().toString().replace(".","").replace(":","");
		System.out.println(var1);
		Framework.ReportPath=var1;
		File file2 = new File(var1);
        if (!file2.exists()) {
            if (file2.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
		
        }	
    	
    	
       
        String ReportFileName=Framework.ReportPath+"\\TestReport.htm";
        System.out.println("Report Path="+ReportFileName);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportFileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(ReportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(ReportFileName);
 
        Framework.extent = new ExtentReports();
        Framework.extent.attachReporter(htmlReporter);
 
        return Framework.extent;
    }
    
    public static ExtentTest getExtentTestInstance(String TestName)
    {
    	ExtentTest extentTest = Framework.extent.createTest(TestName,"Description");
        test.set(extentTest);
        
    	return test.get();
    }
    
    
    public static void logText()
    {
    	
    	
    }
}