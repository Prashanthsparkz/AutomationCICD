package Prashanth_maven_project.Maven_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Prashanth_maven_project.Abstract_comp.Abstractcomp;

public class CartPage extends Abstractcomp{

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
PageFactory.initElements(driver, this);

	}

	// WebElement email = driver.findElement(By.id("userEmail"));

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List <WebElement> li1;

	
	@FindBy(css="li[class='totalRow'] button[type='button']") WebElement add ;
	

	
	
	
	By ch = By.xpath("(//section[@class='ta-results list-group ng-star-inserted'])[1]");
	
	
	
	
	


	public boolean checkele( String prod) {
     
		boolean flag = li1.stream().anyMatch(s -> s.getText().equals(prod));

		return flag;
		
		
	}
	
	
	public CheckOutPage clicke() {
		add.click();
		
		return new CheckOutPage(driver);
		
	}
	
	


//	driver.findElement(By.xpath("")).sendKeys("India");
//
//	wait.until(ExpectedConditions.visibilityOfElementLocated(
//			By.xpath("(//section[@class='ta-results list-group ng-star-inserted'])[1]")));
//
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//	
	
//	public void checkli(String word) {
//		checklist.sendKeys(word);
//		
//		
//		waitapp();
//		
//	}
//	
//	
//	public void waitapp()
//	{
//		waitforeletoappear(ch);
//		select.click();
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,250)", "250");
//		
//		placeorder.click();
//	}
//	
	
	
	
}
