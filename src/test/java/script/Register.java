package script;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import drivers.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {

	public WebDriver driver;
	static SoftAssert s;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	   driver=DriverFactory.driver;
	   driver.findElement(By.xpath("//a[@title='My Account']")).click();
	   driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		s= new SoftAssert();
		s.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).isDisplayed());
	    Map<String, String> map = dataTable.asMap(String.class,String.class);
	    driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
	    Reporter.log("FirstName entered into the Firstname field", true);
	   
	    driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
	    Reporter.log("LastName entered into the Lastname field", true);
	    String str=RandomStringUtils.randomAlphabetic(2);
	    driver.findElement(By.id("input-email")).sendKeys(str+map.get("email"));
	    Reporter.log("Email id Entered into the Email address field", true);
	    driver.findElement(By.id("input-telephone")).sendKeys(map.get("phone"));
	    Reporter.log("Phone number entered into telephone field", true);
	    driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
	    Reporter.log("Password Entered in to the password field", true);
	    driver.findElement(By.id("input-confirm")).sendKeys(map.get("password"));
	    Reporter.log("Password Entered in to the confirm password field", true);
	    s.assertAll();
	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	    driver.findElement(By.xpath("//input[@name='agree']")).click();
	    Reporter.log("Clicked on Privacy Policy", true);
	}

	@And("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Reporter.log("Clicked on Continue button", true);
	}

	@Then("user account should get created successfully")
	public void user_account_should_get_created_successfully() {
		s.assertEquals(driver.findElement(By.xpath("//div[@id='content'] /h1")).getText(),"Your Account Has Been Created!");
	   Reporter.log("successfully Created", true);
	   s.assertAll();
	}

	@And("user selects yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	   driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
	   Reporter.log("Clicked on Yes in news letter", true);
	   
	}

	@Then("user should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		String msg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Reporter.log("The warning message is: "+msg, true);
	  
	}
	
	@When("user enters again the details into below fields")
	public void user_enters_again_the_details_into_below_fields(DataTable dataTable) {
		s= new SoftAssert();
		s.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).isDisplayed());
	    Map<String, String> map = dataTable.asMap(String.class,String.class);
	    driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
	    Reporter.log("FirstName entered into the Firstname field", true);
	   
	    driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
	    Reporter.log("LastName entered into the Lastname field", true);
	    driver.findElement(By.id("input-email")).sendKeys(map.get("email"));
	    Reporter.log("Email id Entered into the Email address field", true);
	    driver.findElement(By.id("input-telephone")).sendKeys(map.get("phone"));
	    Reporter.log("Phone number entered into telephone field", true);
	    driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
	    Reporter.log("Password Entered in to the password field", true);
	    driver.findElement(By.id("input-confirm")).sendKeys(map.get("password"));
	    Reporter.log("Password Entered in to the confirm password field", true);
	    s.assertAll();
	}
	@When("User do not enter any details into any field")
	public void user_do_not_enter_any_details_into_any_field() {
		
		s.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).isDisplayed());
	    driver.findElement(By.id("input-firstname")).sendKeys(" ");
	    Reporter.log("FirstName not entered into the Firstname field", true);
	   
	    driver.findElement(By.id("input-lastname")).sendKeys(" ");
	    Reporter.log("LastName not entered into the Lastname field", true);
	    
	    driver.findElement(By.id("input-email")).sendKeys(" ");
	    Reporter.log("Email id not Entered into the Email address field", true);
	    driver.findElement(By.id("input-telephone")).sendKeys(" ");
	    Reporter.log("Phone number not entered into telephone field", true);
	    driver.findElement(By.id("input-password")).sendKeys(" ");
	    Reporter.log("Password not Entered in to the password field", true);
	    driver.findElement(By.id("input-confirm")).sendKeys(" ");
	    Reporter.log("Password not Entered in to the confirm password field", true);
	    s.assertAll();
	}

	@And("Clicks on continue button")
	public void clicks_on_continue_button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Reporter.log("Clicked on Continue button", true);
	}

	@Then("user should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
	    Reporter.log("The Warning Messages are:", true);
	    List<WebElement> msg = driver.findElements(By.xpath("//div[@class='text-danger']"));
	    for (WebElement text : msg) {
			Reporter.log(text.getText(), true);
		}
	}
}
