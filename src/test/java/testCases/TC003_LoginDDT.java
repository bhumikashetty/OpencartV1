package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
public class TC003_LoginDDT extends BaseClass{
@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriver")
//2nd parameter we are passing because the data provider are created in another class or package
//If data provider was present in same class then 2nd parameter was not required
public void verify_LoginDDT(String email, String pwd, String exp )
{
	logger.info("***********Starting TC003_LoginDDT*************");
	try
	{
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	//loginpage
	LoginPage lp=new LoginPage(driver);
//  lp.setEmail(p.getProperty("email"));
	lp.setEmail(email);
//	lp.setPassword(p.getProperty("pwd"));
	lp.setPassword(pwd);
	lp.setLogin();
	
	//myaccountpage
	MyAccountPage macc= new MyAccountPage(driver);
	boolean targetpage=macc.isMyAccountPageExixts();
	/* 1) Data is valid -- login success --test pass --logout
	                       login failed -- test fail
	                  
	   2) Data is invalid -- login success -- test fail -- logout
	                     login failed -- test pass
	 *///1)
	
	if(exp.equalsIgnoreCase("vaild"))
	{
		if(targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(true);
		}
	}
	 else 
	{
		Assert.assertTrue(false);
	}
	//2)
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("***********Finished TC003_LoginDDT*************");
	}
}
