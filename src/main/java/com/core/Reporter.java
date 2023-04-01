package com.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {
	static BufferedWriter bufferedWriter = null;
	static FileWriter fileWriter=null;
	static ThreadLocal<BufferedWriter> reporter=new ThreadLocal<>();
	
	public static void initializeReport() throws IOException
	{
		fileWriter = new FileWriter(new File(Framework.ReportPath+"\\TestReport.htm"));
		reporter.set(new BufferedWriter(fileWriter));
		reportStart();
	}
	
	
	
	
	
	
	
	
	
	public static void reportStart()
	{
	
	
		File file = new File(Framework.ReportPath+"\\TestReport.htm");
		
				
				
				try 
				{
					fileWriter = new FileWriter(file);
					
					 bufferedWriter = reporter.get();
					 bufferedWriter = new BufferedWriter(fileWriter);
			
					String htmlPage = "<html><head><style><style>\r\n" + 
							"table {\r\n" + 
							"    font-family: arial, sans-serif;\r\n" + 
							"    border-collapse: collapse;\r\n" + 
							"    width: 100%;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"td, th {\r\n" + 
							"    border: 1px solid #dddddd;\r\n" + 
							"    text-align: center;\r\n" + 
							"    padding: 8px;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"tr:nth-child(odd) {\r\n" + 
							"    background-color: #dddddd;\r\n" + 
							"}</style></head><body>" ;
			
					//bufferedWriter.write(htmlPage);
					bufferedWriter.append(htmlPage);
				
		
				} 
				catch (IOException e) 
				{
			// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		//}
		
		
		
	}
	
	public static void addScenario(String ScenarioName) throws IOException
	{
		
		bufferedWriter.append("<b><table align=\"center\" width=\"100%\"><tbody><tr><th colspan=\"3\">Scenario Name="+ScenarioName+"</th></tr><tr><th>Scenario Step</th><th>Scenario Description</th><th>Step Status</th></tr>");
		
	}
	
	public static void addReportStep(String ScenarioStep,String Description,String Status,String ScreenshotLink) throws IOException
	{
		
		if(Status.equalsIgnoreCase("Fail"))
		
			bufferedWriter.append("<tr><td>"+ScenarioStep+"</td><td>"+Description+"</td><td style=\"color:red;\">"+Status+"</td></tr>");
		else
			bufferedWriter.append("<tr><td>"+ScenarioStep+"</td><td>"+Description+"</td><td style=\"color:green;\">"+Status+"</td></tr>");
	}
	
	public static void addReportStepError(String ErrorRootCause) throws IOException
	{
		
		bufferedWriter.append("<tr><td colspan=\"3\" style=\"color:red;\">"+ErrorRootCause+"</td></tr>");
	}
	
	public static void endScenario() throws IOException
	{
		
		bufferedWriter.append("</tbody></table>");
		
	}
	
	public static void reportWrite()
	{
		
		
	}
	
	public synchronized static void ReportEnd()
	{
	
		try {
			
		
			bufferedWriter.append("</body></html>");
			
			System.out.println("Html page created");
			bufferedWriter.flush();
			fileWriter.flush();
			bufferedWriter.close();
			fileWriter.close();
		}
		catch (IOException e) 
		{
	// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
