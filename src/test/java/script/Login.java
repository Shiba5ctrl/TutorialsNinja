package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import drivers.DriverFactory;
import io.cucumber.java.en.*;

public class Login {

	public WebDriver driver;
	static SoftAssert s;
	
	@Given("user has navigated to login page")
	public void user_has_navigated_to_login_page() {
	  driver=DriverFactory.driver;
	  driver.findElement(By.xpath("//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	  Reporter.log("Navigated to login page", true);
	}

	@When("user enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String string) {
	    driver.findElement(By.id("input-email")).sendKeys(string);
	    Reporter.log("Entered Email Id in to the email adress text field", true);
	}

	@And("user enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String string) {
	  driver.findElement(By.id("input-password")).sendKeys(string);
	  Reporter.log("Entered Password into the Password textfield", true);
	}

	@And("user clicks on the  login button")
	public void user_clicks_on_the_login_button() {
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    Reporter.log("**Clicked on Login Button**", true);
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	    WebElement wb = driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
	    s=new SoftAssert();
	    s.assertTrue(wb.isDisplayed());
	    Reporter.log(wb.getText()+" is displayed", true);
	    s.assertAll();
	}

	@When("user enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String string) {
		 driver.findElement(By.id("input-email")).sendKeys(string);
		    Reporter.log("Entered invalid Email Id in to the email adress text field", true);
	}

	@Then("user should get proper warning message")
	public void user_should_get_proper_warning_message() {
	    WebElement wb = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	    Reporter.log(wb.getText()+" : is displayed", true);
	    }

	@Then("user should get proper warning message about credentials")
	public void user_should_get_proper_warning_message_about_credentials() {
	    WebElement wb=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	    Reporter.log(wb.getText()+" : is displayed", true);
	}

	@When("user do not enter email id into email field")
	public void user_do_not_enter_email_id_into_email_field() {
		 driver.findElement(By.id("input-email")).sendKeys(" ");
		    Reporter.log("Entered nothing in to the email adress text field", true);
	}

	@And("user do not enter password into password field")
	public void user_do_not_enter_password_into_password_field() {
		driver.findElement(By.id("input-password")).sendKeys(" ");
		  Reporter.log("Entered nothing into the Password textfield", true);
	}

	@And("user clicks on the login button")
	public void user_clicks_on_the_login_button1() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	    Reporter.log("**Clicked on Login Button**", true);
	}

	@Then("user should get proper warning for all mandatory field")
	public void user_should_get_proper_warning_for_all_mandatory_field() {
		 WebElement wb=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		    Reporter.log(wb.getText()+" : is displayed", true);
	}

}
