package Prashanth_maven_project.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Prashanth_maven_project.Maven_Project.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String prod = "ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();

		
		LandingPage lp = new LandingPage(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");

		
		
		
		driver.findElement(By.id("userEmail")).sendKeys("sparkz1@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Sparkz1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// List<WebElement> li =
		// driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));

		List<WebElement> li = driver.findElements(By.cssSelector(".mb-3"));

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mb-3")));

//   for(int i=0;i<li.size();i++) {	
//	   
//	 String n =  li.get(i).getText();
//	 System.out.println(n);
//	 if(n.equals(prod)) {
//		 System.out.println(n);
//		 driver.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
//		 break;
//	 }
//   }

		WebElement prd = li.stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals(prod)).findFirst()
				.orElse(null);

		System.out.println(prd);
//prd.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();

		prd.findElement(By.cssSelector(".card button:last-of-type")).click();

		Thread.sleep(3000);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//

		List<WebElement> li1 = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

		boolean flag = li1.stream().anyMatch(s -> s.getText().equals(prod));

		Assert.assertTrue(flag);

		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//section[@class='ta-results list-group ng-star-inserted'])[1]")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

//driver.quit();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "250");
		;
		driver.findElement(By.cssSelector(".action__submit")).click();

		String n = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(n);

		Assert.assertEquals(n, "THANKYOU FOR THE ORDER.");

	}

}
