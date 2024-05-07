package Prashanth_maven_project.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Prashanth_maven_project.Maven_Project.CartPage;
import Prashanth_maven_project.Maven_Project.CheckOutPage;
import Prashanth_maven_project.Maven_Project.LandingPage;
import Prashanth_maven_project.Maven_Project.ProductPage;
import Prashanth_maven_project.Maven_Project.confirmpage;
import Prashanth_maven_project.TestComponents.BaseTest;
import Prashanth_maven_project.TestComponents.Rety;

public class ErrorValidations extends BaseTest {

	@Test(groups= {"ErrorHandlings"}, retryAnalyzer = Rety.class)
	
	public void LoginErrorVal() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		

		lp.landing("sparkz1@gmail.com", "Sparkz12");

		
	Assert.assertEquals("Incorrect email or password.", lp.Errormsg());	
		
		
	}

}
