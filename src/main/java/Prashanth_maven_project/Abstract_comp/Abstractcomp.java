package Prashanth_maven_project.Abstract_comp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Prashanth_maven_project.Maven_Project.CartPage;
import Prashanth_maven_project.Maven_Project.Orderpage;

public class Abstractcomp {

	WebDriver driver;
	public Abstractcomp(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']") WebElement add;

	@FindBy(css = "[routerlink*='myorders']") WebElement viewOrders;
	
	
			
			
	public void waitforeletoappear(By Findby ) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated((Findby)));
		 
	
		 
		 
	}
	
public void waitforWebeletoappear(WebElement Findby ) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf((Findby)));
		 
	
		 
		 
	}


	public void waitforeletodisappear( ) throws InterruptedException {
		
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	 wait.until(ExpectedConditions.invisibilityOf(ele));
//	
	}
	
	public CartPage addtocart() {
		add.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public Orderpage ViewOrders() {
		viewOrders.click();
			Orderpage orderpage = new Orderpage(driver);
		return orderpage;
	}
	
	
}	
