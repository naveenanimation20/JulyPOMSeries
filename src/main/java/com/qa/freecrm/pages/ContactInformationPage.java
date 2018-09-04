package com.qa.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.freecrm.util.Constants;

public class ContactInformationPage extends TestBase{
	
	@FindBy(xpath = "//fieldset//legend[text()='Contact Information']")
	WebElement contactInfoHeader;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(id = "company_position")
	WebElement companyPosition;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void switchToFrame(){
		driver.switchTo().frame(Constants.MAIN_PANEL_FRAME_NAME);
	}
	
	public void createContact(String fn, String ln, String compPos){
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		companyPosition.sendKeys(compPos);
		saveBtn.click();
	}
	
	
	

}
