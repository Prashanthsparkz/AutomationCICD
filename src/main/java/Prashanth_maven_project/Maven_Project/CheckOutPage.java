package Prashanth_maven_project.Maven_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Prashanth_maven_project.Abstract_comp.Abstractcomp;

public class CheckOutPage extends Abstractcomp{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//input[@placeholder='Select Country']")) WebElement select ;
	
	@FindBy(css=".action__submit") WebElement placeorder;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]") WebElement checklist ;
	
	@FindBy(xpath="//input[@placeholder='Select Country']") WebElement chose;
	
	By path1 = By.xpath("(//section[@class='ta-results list-group ng-star-inserted'])[1]");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]") WebElement selectcountry;
	

	
	public void SelectCountry(String Country)
	{
		
		

	
		chose.sendKeys(Country);
		waitforeletoappear(path1);
		selectcountry.click();

	}
	
	public confirmpage Submitorder() throws InterruptedException {
		//Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		placeorder.click();
		
		

	return new confirmpage(driver) ;
	}
}
