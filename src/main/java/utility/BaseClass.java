package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public void launchBrowser() {
		String browser = ConfigFileReader.getBrowser();
		String url = ConfigFileReader.getBaseURL();

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		//driver.get(url);
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
