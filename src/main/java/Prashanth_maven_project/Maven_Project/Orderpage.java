package Prashanth_maven_project.Maven_Project;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prashanth_maven_project.Abstract_comp.Abstractcomp;

public class Orderpage extends Abstractcomp {
	WebDriver driver;
	public Orderpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="tr td:nth-child(3)") List <WebElement> productslist ;
	

	 
	
	

	public boolean VerifyDisplay(String prod) {
		
		boolean flag = productslist.stream().anyMatch(s -> s.getText().equals(prod));

		return flag;
	}
}
