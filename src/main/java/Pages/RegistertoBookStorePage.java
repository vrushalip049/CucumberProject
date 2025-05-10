package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistertoBookStorePage {
	WebDriver driver;
	By firstName = By.xpath("//*[@id='firstname']");
	By lastName = By.xpath("//*[@id='lastname']");
	By usertName = By.xpath("//*[@id='userName']");
	By password = By.xpath("//*[@id='password']");
	By captcha = By.xpath("//*[@id='recaptcha-anchor']");
	By register = By.xpath("//*[@id='register']");
	By backToLogin = By.xpath("//*[@id='gotologin']");

	public RegistertoBookStorePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getRandomEmail() {
		return "Automation" + System.currentTimeMillis() + "@open.com";
	}

	public void enterFirstName(String firstname) {
		driver.findElement(firstName).sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		driver.findElement(lastName).sendKeys(lastname);
	}

	public void enterUserName(String username) {
		driver.findElement(usertName).sendKeys(username);
	}

	public void enterPasswordName(String Password) {
		driver.findElement(password).sendKeys(Password);
	}

	public void ClickCaptch(String Captcha) {
		
	WebElement captchaCheck= driver.findElement(captcha);
		if (captchaCheck.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", captchaCheck);
			js.executeScript("arguments[0].click();", captchaCheck);
			//driver.findElement(captcha).click();
		} else {
			System.out.println("Captch is not provided..");
		}

	}

	public void ClickRegister() {
		WebElement resisterbutton= driver.findElement(register);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", resisterbutton);
		js.executeScript("arguments[0].click();", resisterbutton);
	}

	public void ClickOnGoBackToLogin() {
		driver.findElement(backToLogin).click();
	}

	// User Register Successfully. -> oK
}
