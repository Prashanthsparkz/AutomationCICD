package Prashanth_maven_project.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Prashanth_maven_project.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentReports extent = new ExtentReporterNG().getReportObj();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
			test = extent.createTest(result.getMethod().getMethodName());
		
		
	}
		
	
@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
	//text.log(Status.FAIL, "Test Failed");
	test.fail(result.getThrowable());
	
	try {
		driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	}
	 catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	String filepath = null;
	try {
		filepath = getScreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	
	
	
	}

@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
	
	test.log(Status.PASS, "Test Passed");
	
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	extent.flush();
	
	
}
}
