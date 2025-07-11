package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.RegistertoBookStorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utility.BaseClass;
import utility.ConfigFileReader;
import org.springframework.boot.test.context.SpringBootTest;

//import org.apache.log4j.Logger;

@SpringBootTest
public class RegistrationFeatureStepDefs extends BaseClass {
	

	// private WebDriver driver;
	private RegistertoBookStorePage registertoBookStorePage;
	// Initialize Log4j logs
	//Logger log = Logger.getLogger("logger");

	/*
	 * @Before public void setUp() { launchBrowser(); }
	 * 
	 * @After public void tearDown() { closeBrowser(); }
	 */

	
	@Given("User is on Register Home page")
	public void user_is_on_register_home_page() throws InterruptedException {
		launchBrowser();
		registertoBookStorePage = new RegistertoBookStorePage(driver);
		driver.get(ConfigFileReader.getRegisterURL());
		Thread.sleep(2000);

	}

	@When("User enter {string} {string} {string} {string} and {string}")
	public void user_enter_and(String firstname, String lastname, String username, String password, String captcha)
			throws InterruptedException {
		registertoBookStorePage.enterFirstName(firstname);
		Thread.sleep(1000);
		registertoBookStorePage.enterLastName(lastname);
		Thread.sleep(1000);
		registertoBookStorePage.enterPasswordName(username);
		Thread.sleep(1000);
		registertoBookStorePage.enterUserName(password);
		Thread.sleep(1000);
		
		// Switch to reCAPTCHA iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title, 'reCAPTCHA')]")));
		// Scroll into view and click via JS
		
		
		
		registertoBookStorePage.ClickCaptch(captcha);
		Thread.sleep(1000);
		// registertoBookStorePage.ClickCaptch();

		// Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("click on login page and captcha")
	public void click_on_login_page_and_captcha() {
		registertoBookStorePage.ClickRegister();
	}

	@Then("Register successful")
	public void register_successful() {
		closeBrowser();
	}

	@Then("Register Unsuccessful")
	public void register_unsuccessful() {

		//log.info("Login unsucessful due to invalid inputs..");
		closeBrowser();
	}

}
