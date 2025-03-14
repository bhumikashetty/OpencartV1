package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_AccountRegisterTest extends BaseClass
{
	   
    @Test(groups= {"Regression", "Master"})
    public void verify_accout_registration()
     {
    	logger.info("*******Starting TC001_AccountRegisterTest******");
    	
    	HomePage hp= new HomePage(driver);
    	hp.clickMyAccount();
    	hp.clickRegister();
    	logger.info("*******Clicked on MY Account******");
    	
    	
    	AccountRegisterPage regpage=new AccountRegisterPage(driver);
    	
    	logger.info("Filling the register form");
    	regpage.setFirtsname(randomeString().toUpperCase());//converted to uppercase
    	regpage.setLastname(randomeString().toUpperCase());
    	regpage.setemail(randomeString() + "@gmail.com");
    	regpage.setTelephone(randomeNumber());
    	
    	String password=randomeAlphanumeric();
    	
    	regpage.setPassword(password);
    	regpage.setConfirmPassword(password);
    	
    	regpage.setPrivacyPolicy();
    	regpage.setContinue();
    	
    	logger.info("******Validating expected message******");
    	String confmesg=regpage.getConfirmationMessage();
    	
    	Assert.assertEquals(confmesg,"Your Account Has Been Created!");
    	
     }
       
}	

    	
    	
    	
     	
  
