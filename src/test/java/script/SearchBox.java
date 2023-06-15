package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import drivers.DriverFactory;
import io.cucumber.java.en.*;

public class SearchBox {
	WebDriver driver;
	static SoftAssert s;
	@Given("User opens application")
	public void user_opens_application() {
	    driver=DriverFactory.driver;
	}

	@When("user enters valid product name {string} into search box field")
	public void user_enters_valid_product_name_into_search_box_field(String string) {
	   driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);
	   Reporter.log("Product name Entered in to the Search text field"	, true	);
	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {
	   driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	   Reporter.log("Clicked on Search Button==", true);
	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	   WebElement wb = driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']"));
	   s= new SoftAssert();
	   s.assertTrue(wb.isDisplayed(), "Product Displayed==");
	   s.assertAll("Not Passed");
	}

	@When("user enters invalid product name {string} into search box field")
	public void user_enters_invalid_product_name_into_search_box_field(String string) {
	   driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);
	   Reporter.log("Product name Entered in to the Search text field"	, true	);
	}
	
	@Then("user should get message no matching product")
	public void user_should_get_message_no_matching_product() {
	   WebElement wb = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"));
	   s.assertTrue(wb.isDisplayed(), "message"+wb.getText());
	   s.assertAll("not Passed");
	}

	@When("user do not enter anything into search box field")
	public void user_do_not_enter_anything_into_search_box_field() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(" ");
		   Reporter.log("Nothing Entered in to the Search text field"	, true	);
	}

	@Then("user should get proper message")
	public void user_should_get_proper_message() {
		Reporter.log("Should get Some Relevent Product", true);
	}
}
