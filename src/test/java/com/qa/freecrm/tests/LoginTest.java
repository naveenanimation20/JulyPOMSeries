package com.qa.freecrm.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(LoginTest.class);

	
	@BeforeMethod
	public void setUp(){
		//log = Logger.getLogger(LoginTest.class);
		log.info("******** Starting Login Class Test Cases ***************");
		testBase = new TestBase();
		driver = testBase.init();
		prop = testBase.initProperty();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		log.info("url is launched -- "+ prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		log.info("Test - loginPageTitleTest - starting");
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: "+ title);
		log.info("login page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		log.info("Test - loginPageTitleTest -- ended");
	}
	
	@Test(priority=2)
	public void freeCrmLoginTest(){
		log.info("Test - freeCrmLoginTest - starting");
		log.info("Username is: "+ prop.getProperty("username"));
		log.info("Password is: "+ prop.getProperty("password"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Test - freeCrmLoginTest - ended");

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("Browser is closed");
	}
	

}
