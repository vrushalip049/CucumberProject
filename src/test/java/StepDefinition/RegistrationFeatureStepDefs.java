package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.RegistertoBookStorePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utility.BaseClass;
import utility.ConfigFileReader;

import org.apache.log4j.Logger;

public class RegistrationFeatureStepDefs extends BaseClass {
	//private WebDriver driver;
	private RegistertoBookStorePage registertoBookStorePage;
	// Initialize Log4j logs
	Logger log = Logger.getLogger("logger");

	/*
	 * @Before public void setUp() { launchBrowser(); }
	 * 
	 * @After public void tearDown() { closeBrowser(); }
	 */

	@SuppressWarnings("deprecation")
	@Given("User is on Register Home page")
	public void user_is_on_register_home_page() throws InterruptedException {
		launchBrowser();
		registertoBookStorePage = new RegistertoBookStorePage(driver);
		driver.get(ConfigFileReader.getRegisterURL());
		Thread.sleep(2000);

	}

	@When("User enter {string} {string} {string}  {string} and {string}")
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
		// registertoBookStorePage.ClickCaptch();

	}

	@Then("click on login page and captcha")
	public void click_on_login_page_and_captcha() {

	}

	@Then("Register successful")
	public void register_successful() {
		 closeBrowser();
	}
}
