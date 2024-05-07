package Prashanth_maven_project.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Prashanth_maven_project.Maven_Project.CartPage;
import Prashanth_maven_project.Maven_Project.CheckOutPage;
import Prashanth_maven_project.Maven_Project.LandingPage;
import Prashanth_maven_project.Maven_Project.ProductPage;
import Prashanth_maven_project.Maven_Project.confirmpage;
import Prashanth_maven_project.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	
	public LandingPage lp;
	public ProductPage pg;
	public confirmpage cmp ;
	
	public CartPage cp;
	public CheckOutPage checkout;
	 
	@Given("I land on the Ecommerce Page")
	public void I_land_on_the_Ecommerce_Page() throws IOException {
	
		lp = launchapp();
	
	
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String name, String password) {
		
		pg = lp.landing(name, password);
	}
	
	 @When("^I add the product (.+) to cart$")
	 public void I_add_the_product_to_cart(String productname) throws InterruptedException{
		
		 List<WebElement> li = pg.getprodlist();

			pg.addprod(productname);
	 }
	 
	 @And("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_the_order(String productname) throws InterruptedException {
		 cp = pg.addtocart();
		 Boolean match = cp.checkele(productname);

			
			Assert.assertTrue(match);

			 checkout = cp.clicke();

			checkout.SelectCountry("India");

			 cmp = checkout.Submitorder();

			
	 }
	 
	 @Then("{string} message is displayed on confirmation page")
	 public void message_is_displayed_on_confirmation_page(String string) {
		 String confirm = cmp.confirmpag();

			//System.out.println(confirm);
			Assert.assertTrue(confirm.equalsIgnoreCase(string));
			driver.close();
	 }
	 
	 @Then("{string} message is displayed on login page")
	 
	 public void message_is_displayed_on_login_page(String string) {
		 
		 

			
			Assert.assertEquals(string, lp.Errormsg());	
			driver.close();
		 
	 }
	 
}
