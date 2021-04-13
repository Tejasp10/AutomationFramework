package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	com.orangehrm.qa.pages.HomePage HomePage;
	
	
	public  LoginPageTest() {
		super ();
	}	
	
	//Added line to master check merge 
	
	
	@BeforeMethod
	public void setup ()
	{
		intialization ();
		loginPage = new LoginPage();
		
	}
	
	//Some more random changes
	
	@Test (priority = 3)
	public void LoginTest ()
	
	{
		HomePage =  loginPage.logintoOrangeHRM("Admin","admin123");
		
	}
	
	@Test (priority = 2) 
	public void LoginPageLogoTest()
	
	{
		boolean LogoCheck = loginPage.validateloginpageLogo();
		Assert.assertTrue(LogoCheck, "Login Page Logo did not load before Timeout");
		
	}
	
	@Test (priority = 1)
	public void LoginPageTitleTest ()
	
	{
		String strTitle = loginPage.VerifyLoginPageTitle();
		Assert.assertEquals(strTitle, "OrangeHRM");
		
	}
	
	@AfterMethod
	public void TearDown ()
	{
		//driver.quit();
		
	}

}
