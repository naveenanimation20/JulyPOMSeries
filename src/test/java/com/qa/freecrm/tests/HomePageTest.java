package com.qa.freecrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.ContactInformationPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;
import com.qa.freecrm.pages.TestBase;
import com.qa.freecrm.util.Constants;

public class HomePageTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactInformationPage contactInformationPage;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		driver = testBase.init();
		prop = testBase.initProperty();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyContactInformationPageTest(){
		homePage.switchToFrame();
		homePage.clickOnNewContact();
	}
	
	@Test(priority=3)
	public void createNewContactTest(){
		homePage.switchToFrame();
		contactInformationPage = homePage.clickOnNewContact();
		contactInformationPage.createContact("Tom", "Steve", "Automation QA Engineer");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
