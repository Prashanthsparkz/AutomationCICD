package Prashanth_maven_project.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Prashanth_maven_project.Maven_Project.CartPage;
import Prashanth_maven_project.Maven_Project.CheckOutPage;
import Prashanth_maven_project.Maven_Project.Orderpage;
import Prashanth_maven_project.Maven_Project.ProductPage;
import Prashanth_maven_project.Maven_Project.confirmpage;
import Prashanth_maven_project.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	//String prod = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData" , groups= {"purchase"})
	public void StandAlone(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		



		ProductPage pg = lp.landing(input.get("email"), input.get("pwd"));

//		ProductPage pg = new ProductPage(driver);

		List<WebElement> li = pg.getprodlist();

		pg.addprod(input.get("prod"));

		CartPage cp = pg.addtocart();

		Boolean match = cp.checkele(input.get("prod"));

		// cp.checkele(prod);
		Assert.assertTrue(match);

		CheckOutPage checkout = cp.clicke();

		checkout.SelectCountry("India");

		confirmpage cmp = checkout.Submitorder();

		String confirm = cmp.confirmpag();

		System.out.println(confirm);
		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	@Test(dependsOnMethods= {"StandAlone"})
	public void VerifyOrders(HashMap<String,String> input1) {
		

    ProductPage pg =  lp.landing(input1.get("email"),input1.get("pwd"));
     Orderpage op = pg.ViewOrders();
       

     
     Assert.assertTrue(op.VerifyDisplay(input1.get("prod")));
    
			
	}

//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"sparkz1@gmail.com","sparkz1@gmail.com" ,"ADIDAS ORIGINAL" },{"kirans7890@gmail.com","Kiran1234","ZARA COAT 3" }};
//		
//	}
//	
	@DataProvider
	public Object[][] getData() throws IOException {

//		HashMap<String, String>  map = new HashMap<String, String>();
//		map.put("email","sparkz1@gmail.com");
//		map.put("pwd","Sparkz1234");
//		map.put("prod","ADIDAS ORIGINAL");
//		
//		HashMap<String, String>  map1 = new HashMap<String, String>();
//		map1.put("email","kirans7890@gmail.com");
//		map1.put("pwd","Kiran1234");
//		map1.put("prod","ZARA COAT 3");
//		
		List<HashMap<String,String>> data = JsonReader(System.getProperty("user.dir")+"\\src\\test\\java\\Prashanth_maven_projects\\Data\\PurchaseOrder.json");
		return new  Object[][] {{data.get(0)},{data.get(1)}};
		

	}
	
	
	
}
