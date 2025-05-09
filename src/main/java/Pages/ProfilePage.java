package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	WebDriver driver;
	By firstName = By.xpath("//*[@id='firstname']");
	By lastName = By.xpath("//*[@id='lastname']");
	By usertName = By.xpath("//*[@id='userName']");
}
