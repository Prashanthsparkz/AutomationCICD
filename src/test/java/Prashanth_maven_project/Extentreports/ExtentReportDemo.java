package Prashanth_maven_project.Extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	
	
	@BeforeTest
	public void config() {

		//ExtentReports , ExtentSparkReporter
		String path =  System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Results");
		 reporter.config().setDocumentTitle("Test Results");
		 
		 
		  extent = new ExtentReports();
		 
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Prashanth");
	}

	@Test
	public void initialize() {
		
		extent.createTest("Initial test");
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
