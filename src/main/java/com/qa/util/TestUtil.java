package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.BaseTest;

public class TestUtil extends BaseTest{
	

	public static void takeScreenshot() throws IOException {
		
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");	DateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		Date d = new Date();
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +d+ ".png"));
	}
	
	
	

}
