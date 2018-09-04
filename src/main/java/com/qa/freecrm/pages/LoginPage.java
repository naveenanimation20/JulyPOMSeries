package com.qa.freecrm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	// webelements and actions(methods) -- features

	// pagefactory pattern: for WebElements:

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		// loginBtn.click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", loginBtn);
		
		return new HomePage(driver);

	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
