package com.qa.freecrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.pages.TestBase;
import com.qa.freecrm.util.Constants;

public class LoginTest {
	
	//only for test cases
	//setup -- init browser, url
	//test -- test case
	//tear down -- close the browser
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		driver = testBase.init();
		prop = testBase.initProperty();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void freeCrmLoginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
