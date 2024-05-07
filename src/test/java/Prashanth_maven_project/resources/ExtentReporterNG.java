package Prashanth_maven_project.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	 
	
	

	public static ExtentReports getReportObj() {

		//ExtentReports , ExtentSparkReporter
		String path =  System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Results");
		 reporter.config().setDocumentTitle("Test Results");
		 
		 
		 ExtentReports  extent = new ExtentReports();
		 
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Prashanth");
		 
		 return extent;
		 
		 
	}

	
}
