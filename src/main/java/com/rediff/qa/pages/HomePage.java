package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.TestBase;

public class HomePage extends TestBase {

	// PageFactory == Object Repository
	@FindBy(xpath = "//span[@class='hmsprite logo']")
	WebElement home_page_logo;
	@FindBy(xpath = "//a[@href='https://mail.rediff.com/cgi-bin/login.cgi' and contains(text(),'Rediffmail')]")
	WebElement rediff_mail_icon;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions or Methods
	public String checkTitle() {
		return driver.getTitle();
	}

	public LoginPage clickRediffMailIcon() {

		rediff_mail_icon.click();
		return new LoginPage();
	}
	
	public boolean checkHomePageLogo()
	{
		return home_page_logo.isDisplayed();
	}

}
