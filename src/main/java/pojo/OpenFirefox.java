package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefox {

	public static WebDriver FireFoxB() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		return driver;
	}
}