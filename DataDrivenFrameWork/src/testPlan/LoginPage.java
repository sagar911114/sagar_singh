package testPlan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ExcelDataConfig;



public class LoginPage {
	
	
	WebDriver driver;

		@Test(dataProvider="ExcelData")
		public void LoginTest(String username, String password) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sagar\\Desktop\\chromedriver.exe\\");
			driver= new ChromeDriver();
			driver.get("http://demosite.center/wordpress/wp-login.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			LoginPageFac login=PageFactory.initElements(driver, LoginPageFac.class);
			
			login.uId.sendKeys(username);
			login.passId.sendKeys(password);
			login.button_link.click();
			
			String actual_title=driver.getTitle();
			
			String expected_title="Dashboard ‹ WordPress Demo Install — WordPress";
			
			Assert.assertEquals(actual_title, expected_title);
			
		}
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		@DataProvider(name="ExcelData")
		public Object[][] dataValue(){
			
			//We will import data from excel separate class and calling that class here by creating object
			ExcelDataConfig config= new ExcelDataConfig("E:\\DataSheet.xlsx");
			
			int rows=config.getRowCount(0);
			
			Object data[][]= new Object[rows][2];
			
			for (int i=0;i<rows;i++) {
				
				data[i][0]=config.getData(0, i, 0);
				data[i][1]=config.getData(0, i, 1);
				
			}
			return data;
			
		}

	}

