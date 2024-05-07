package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="Prashanth_maven_project.StepDefinition" , monochrome=true,tags="@Regression",
plugin= {"html:target/cucumber.html"} )

public class TestNGRunner extends AbstractTestNGCucumberTests{

	

}
