package com.rediff.qa.util;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.rediff.qa.base.TestBase;


public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	
	public static void takeScreenshotOfTest() throws IOException {
		File scrshootfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshootfile,new File(System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png"));
	}


}
