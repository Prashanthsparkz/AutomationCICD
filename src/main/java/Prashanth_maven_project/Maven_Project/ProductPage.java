package Prashanth_maven_project.Maven_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prashanth_maven_project.Abstract_comp.Abstractcomp;

public class ProductPage extends Abstractcomp{

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
//List<WebElement> li = driver.findElements(By.cssSelector(".mb-3"));

	
	@FindBy(css = ".mb-3")
	List<WebElement> li;
	
	@FindBy(css = ".ng-animating")
	WebElement ani;

	

	
	
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> li1;
	
	By productsBy =By.cssSelector(".mb-3");
    By AddCart = By.cssSelector(".card button:last-of-type");
    By tost = By.cssSelector("#toast-container");
    //By ani = By.cssSelector(".ng-animating");
    
    
	
	public  List<WebElement> getprodlist() {
		
		waitforeletoappear(productsBy);
		return li;
	}
	
	public WebElement getprodname(String prod) {
		WebElement prd = getprodlist().stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals(prod)).findFirst()
				.orElse(null);
		return prd;
		
	}
	
	public void addprod(String prodname) throws InterruptedException {
		
	WebElement prd=	getprodname(prodname);
		prd.findElement(AddCart).click();
		waitforeletoappear(tost);
		waitforeletodisappear();
		
		
		
		
	}
	
	
}
