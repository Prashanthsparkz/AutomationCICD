package Prashanth_maven_project.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rety implements IRetryAnalyzer{

	int count =0;
	int maxretry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxretry)
		{
			count++;
			return true;
		}
		return false;
	}
}
