package Prashanth_maven_project.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Prashanth_maven_project.Maven_Project.LandingPage;

public class BaseTest {

	public LandingPage lp;	
	public WebDriver driver;
	public WebDriver inidriver() throws IOException {
		
		//property class
	 
		
		Properties prop = new  Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Prashanth_maven_project\\resources\\GobalData.properties");
		prop.load(fi);
		
		String browsername = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		//String browsername = prop.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			
			if(browsername.contains("headless")) {
				options.addArguments("headless");	
				
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension (1400,900) );
			
		} else if(browsername.equalsIgnoreCase("edge")){
			//edge
			driver = new EdgeDriver();
			
		} else if(browsername.equalsIgnoreCase("firefox")) {
			//firefox
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
		return driver;
	}
	
public List<HashMap<String, String>> JsonReader(String filepath) throws IOException {
		
		//read json to string
	String jsonContent=	FileUtils.readFileToString(new File(filepath),
			StandardCharsets.UTF_8);
	
	//String to hashmap jaskson databind
	ObjectMapper mapper =  new ObjectMapper();
	
	List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;
	//{map,map}
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchapp() throws IOException {
		 driver = inidriver();
		 
			 lp = new LandingPage(driver);
			lp.Goto();
			
			return lp;
	}
	
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		 
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"\\reports\\"+ testcasename +".png");
		
		
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports\\"+ testcasename +".png";
	}
	
	
	
	//@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
		
	}
	

	
}
