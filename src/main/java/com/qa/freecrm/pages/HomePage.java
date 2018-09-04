package com.qa.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.util.Constants;

public class HomePage extends TestBase{

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsTab;
	
	@FindBy(linkText = "New Contact")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsTab;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public void switchToFrame(){
		driver.switchTo().frame(Constants.MAIN_PANEL_FRAME_NAME);
	}
	
	public void clickContactsTab(){
		contactsTab.click();
	}
	
	public ContactInformationPage clickOnNewContact(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsTab).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		newContactLink.click();
		
		return new ContactInformationPage(driver);
	}
	
	
	public void clickDealsTab(){
		dealsTab.click();
	}
	
	
	
	
	
}
