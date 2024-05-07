package Prashanth_maven_project.Maven_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prashanth_maven_project.Abstract_comp.Abstractcomp;

public class LandingPage extends Abstractcomp{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
PageFactory.initElements(driver, this);

	}

	// WebElement email = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement email1;

	@FindBy(id = "userPassword")
	WebElement userPassword1;

	@FindBy(id = "login")
	WebElement login;
	
	
	@FindBy(css = "[class *='flyInOut']")
	WebElement Errormsg;
	
	
	//.ng-tns-c4-8.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	

	public ProductPage landing(String email ,String userPassword ) {
     
		email1.sendKeys(email);
		userPassword1.sendKeys(userPassword);
		
		login.click();
		return new ProductPage(driver);
	}
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String Errormsg() {
		waitforWebeletoappear(Errormsg);
		
		return  Errormsg.getText();
		
	}
}
