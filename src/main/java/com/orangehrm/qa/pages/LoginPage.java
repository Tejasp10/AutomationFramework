package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	// Page Factory
	
	@FindBy(name="txtUsername")
	WebElement username;

	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement loginPageLogo;
	
	
	public LoginPage () 
	
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String VerifyLoginPageTitle () 
	
	{
		return driver.getTitle();
		
		
	}
	
	public HomePage logintoOrangeHRM (String UserName , String Password)
	
	{
		username.sendKeys(UserName);
		password.sendKeys(Password);
		loginbtn.click();  
		
		return new  HomePage () ;
		
	}
	
	public boolean validateloginpageLogo ()
	
	{
		
		return loginPageLogo.isDisplayed();
	}
	
}
