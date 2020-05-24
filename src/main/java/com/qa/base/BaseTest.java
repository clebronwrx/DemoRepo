package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.WebEventListener;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventlistener;
	public static EventFiringWebDriver e_driver;

	public BaseTest() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/chrislebron/eclipse-workspace/POMMayBuild/src/main/java/com/qa/config/config.properties");
			prop.load(ip);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialize() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/chrislebron/eclipse-workspace/POMMayBuild/drivers/chromedriver");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/chrislebron/eclipse-workspace/POMMayBuild/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
