package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistertoBookStorePage {
	WebDriver driver;
	By firstName = By.xpath("//*[@id='firstname']");
	By lastName = By.xpath("//*[@id='lastname']");
	By usertName = By.xpath("//*[@id='userName']");
	By password = By.xpath("//*[@id='password']");
	By captcha = By.xpath("//*[@id='recaptcha-anchor']");
	By register = By.xpath("//*[@id='register']");
	By backToLogin = By.xpath("//*[@id='gotologin']");
	
	public RegistertoBookStorePage(WebDriver driver)
	{
		driver=this.driver;
	}
	public String getRandomEmail() {
	return "Automation"+System.currentTimeMillis()+"@open.com";
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
	public void ClickCaptch( ) {
		driver.findElement(captcha).click();
		}
	public void ClickRegister() {
		driver.findElement(register).click();
		}
	public void ClickOnGoBackToLogin() {
		driver.findElement(backToLogin).click();
		}
	
	//User Register Successfully. -> oK
}
