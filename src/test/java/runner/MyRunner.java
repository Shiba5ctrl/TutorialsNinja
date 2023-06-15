package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features=".//src/main/resources/FeatureFile",
		glue={"script","hooks"},
		plugin= {"pretty" ,"html:target/cucumber-report.html", "json:target/report.json"},
		publish=true
		
		)
public class MyRunner extends AbstractTestNGCucumberTests {

}
