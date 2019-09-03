package com.rediff.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.rediff.qa.util.TestUtil;
import com.rediff.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventdriver;
	public static WebEventListener eventlistner;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fin = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/" + "com/rediff/qa/config/config.properties");
			prop.load(fin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.geckodriver.driver",
					System.getProperty("user.dir") + "/BrowserDrivers/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			driver = new FirefoxDriver();
		}
		
		eventdriver = new EventFiringWebDriver(driver);
		eventlistner = new WebEventListener();
		eventdriver.register(eventlistner);
		driver = eventdriver; 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
