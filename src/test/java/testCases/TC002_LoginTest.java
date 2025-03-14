package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("**********Starting TC002_LoginTest************");
		
		try
		{
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("pwd"));
		lp.setLogin();
		
		//myaccountpage
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExixts();
		
		Assert.assertEquals(targetpage, true, "Login failed");
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**********Finished TC002_LoginTest************");
	}

}
