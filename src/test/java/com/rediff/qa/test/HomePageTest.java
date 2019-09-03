package com.rediff.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.rediff.qa.base.TestBase;
import com.rediff.qa.pages.HomePage;
import com.rediff.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void checkHomePageTitleTest() {
		Assert.assertEquals(homepage.checkTitle(), "Rediff.com: News | Rediffmail | Stock Quotes | Shopping",
				"Home Page Title is not correct");
	}

	@Test(priority = 2)
	public void checkHomePageLogo() {
		Assert.assertTrue(homepage.checkHomePageLogo(), "Home Page Logo is not displayed");
	}

	@Test(priority = 3)
	public void goToLoginPage() {
		loginpage = homepage.clickRediffMailIcon();

	}

	@AfterMethod
	public void shutdown() {
		driver.quit();
	}

}
