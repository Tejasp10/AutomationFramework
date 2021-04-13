package com.hrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static com.hrm.qa.utlilities.WebEventListener Eventlistner;
	
	public TestBase () 
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:/Users/Tejas/eclipse-workspace/OrangeHRMAutomationSuite/src/main/java/com/hrm/qa/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void intialization () 
	
	{
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "C:/SeleniumFiles/ChromeDriver/chromedriver.exe");
			  driver = new ChromeDriver();
		}
		
		edriver = new EventFiringWebDriver(driver);
		Eventlistner = new com.hrm.qa.utlilities.WebEventListener ();
		edriver.register(Eventlistner);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public static void Clickon (WebElement element , int Timeout)
	{
		new WebDriverWait(driver, Timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}

	
}
