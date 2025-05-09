package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By userName = By.xpath("//*[@id='userName']");
	By password = By.xpath("//*[@id='password']");
	By login = By.xpath("//*[@id='login']");
	By newUser = By.xpath("//*[@id='newUser']");
	
	public LoginPage(WebDriver driver)
	{
		driver=this.driver;
	}
	
	
	public void enterFirstName(String usernname) {
		driver.findElement(userName).sendKeys(usernname);
		}
	public void enterLastName(String Password) {
		driver.findElement(password).sendKeys(Password);
		}
	public void enterUserName() {
		driver.findElement(login).click();
		}
	public void enterPasswordName() {
		driver.findElement(newUser).click();
		}
}
