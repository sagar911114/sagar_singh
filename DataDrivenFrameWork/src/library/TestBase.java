package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestBase {
	
	public static WebDriver driver;
	
	public void IntiateBrowserForURL(String app_url) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sagar\\Desktop\\chromedriver.exe\\");
		driver= new ChromeDriver();
		driver.get(app_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
