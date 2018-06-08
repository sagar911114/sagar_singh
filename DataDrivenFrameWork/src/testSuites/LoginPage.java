package testSuites;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ExcelDataConfig;
import library.LoginPageAction;
import library.TestBase;



public class LoginPage {
	

		@Test(dataProvider="ExcelData")
		public void LoginTest(String username, String password) {
			
			TestBase tb= new TestBase();
			try {
			tb.IntiateBrowserForURL("http://demosite.center/wordpress/wp-login.php");
			LoginPageAction login=PageFactory.initElements(TestBase.driver, LoginPageAction.class);
			
			login.uId.sendKeys(username);
			login.passId.sendKeys(password);
			login.button_link.click();
			
			String actual_title=TestBase.driver.getTitle();
			
			String expected_title="Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress";
			Assert.assertEquals(actual_title, expected_title);
			}
			finally {
				tb.tearDown();
			}
		}
		
		@DataProvider(name="ExcelData")
		public Object[][] dataValue(){
			
			//We will import data from excel separate class and calling that class here by creating object
			ExcelDataConfig config= new ExcelDataConfig("C:\\Users\\Sagar\\git\\DemoGitHub\\DataDrivenFrameWork\\ExcelData\\DataSheet.xlsx");
			
			int rows=config.getRowCount(0);
			
			Object data[][]= new Object[rows][2];
			
			for (int i=0;i<rows;i++) {
				
				data[i][0]=config.getData(0, i, 0);
				data[i][1]=config.getData(0, i, 1);
				
			}
			return data;
		}

	}
