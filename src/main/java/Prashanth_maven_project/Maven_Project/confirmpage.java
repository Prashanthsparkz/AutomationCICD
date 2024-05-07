package Prashanth_maven_project.Maven_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prashanth_maven_project.Abstract_comp.Abstractcomp;

public class confirmpage extends Abstractcomp {

	WebDriver driver;
	
	public confirmpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".hero-primary") WebElement confirmmsg;
	
	public String confirmpag() {
		
		return confirmmsg.getText();
	}
}
