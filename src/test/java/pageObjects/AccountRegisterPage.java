package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage
{
 public AccountRegisterPage(WebDriver driver)
 {
	 super(driver);
 }
 
 @FindBy(xpath="//input[@id='input-firstname']")
 WebElement txtfirstname;
 
 @FindBy(xpath="//input[@id='input-lastname']")
 WebElement txtlastname;

 @FindBy(xpath="//input[@id='input-email']")
 WebElement txtEmail;
 
 @FindBy(xpath="//input[@id='input-telephone']")
 WebElement txtTelephone;
 
 @FindBy(xpath="//input[@id='input-password']")
 WebElement txtPassword;
 
 @FindBy(xpath="//input[@id='input-confirm']")
 WebElement txtConfirmPassword;
 
 @FindBy(xpath="//input[@name='agree']")
 WebElement chkdPolicy;
 
 @FindBy(xpath="//input[@value='Continue']")
 WebElement btncontinue;
 
 @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
 WebElement msgconfirmation;

public void setFirtsname(String fname)
{
	txtfirstname.sendKeys(fname);
}

public void setLastname(String lname)
{
	txtlastname.sendKeys(lname);
}

public void setemail(String email)
{
	txtEmail.sendKeys(email);
}

public void setTelephone(String telphone)
{
	txtTelephone.sendKeys(telphone);
}
 
public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}
 
public void setConfirmPassword(String cpwd)
{
	txtConfirmPassword.sendKeys(cpwd);
}

public void setPrivacyPolicy()
{
	chkdPolicy.click();
}

public void setContinue()
{
	btncontinue.click();
}

 public String getConfirmationMessage()
 {
	 try
	 {
		 return(msgconfirmation.getText());
	 }
	 catch(Exception e)
	 {
		 return(e.getMessage());
	 }
 }

}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 