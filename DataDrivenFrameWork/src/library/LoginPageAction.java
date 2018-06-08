package library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageAction {
	
	@FindBy(how=How.ID,using="user_login")
	@CacheLookup
	public
	WebElement uId;
	
	@FindBy(how=How.XPATH,using="//input[@id='user_pass']")
	public
	WebElement passId;
	
	@FindBy(how=How.ID,using="wp-submit")
	public
	WebElement button_link;
}
