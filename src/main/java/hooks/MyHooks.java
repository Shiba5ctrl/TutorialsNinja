package hooks;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
	WebDriver driver;
	
	@Before
	public void setup() {
		Reporter.log("Browser opened in Chrome", true);
		 driver = DriverFactory.initializeBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://tutorialsninja.com/demo/");
		
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
