package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	WebDriver driver;
	public HomePage (WebDriver driver)
	{
		super(driver);
	}
	//locator
	 @FindBy(xpath="//span[normalize-space()='My Account']")
	 WebElement lnkMyAccount;
	 
	 @FindBy(xpath="(//a[normalize-space()='Register'])[1]")
	 WebElement lnkRegister;
	 
	 @FindBy(linkText = "Login")
	 WebElement lnkLogin;
	 
	 
	 
	// action
	 public void clickMyAccount()
	 {
		 lnkMyAccount.click();
		 
	 }
	 public void clickRegister()
	 {
		 lnkRegister.click();
	 }
	 public void clickLogin()
	 {
		 lnkLogin.click();
	 }
	 
	}




