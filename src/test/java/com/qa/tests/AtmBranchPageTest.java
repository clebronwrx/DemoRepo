package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.AtmBranchPage;
import com.qa.pages.EspanolPage;
import com.qa.pages.HomePage;
import com.qa.pages.SearchPage;

public class AtmBranchPageTest extends BaseTest {

	public HomePage homepage;
	public AtmBranchPage atmbranchpage;
	public SearchPage searchpage;
	public EspanolPage espanolpage;
	
	public AtmBranchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();

		homepage = new HomePage();
		atmbranchpage = new AtmBranchPage();
		searchpage = new SearchPage();
		espanolpage = new EspanolPage();
		atmbranchpage = homepage.clickATMandBranch();
	}
	@Test(enabled = true , groups = "atm")
	public void verifyAtmBranchPageTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Find a Chase ATM or branch near you | Chase Bank");
	}
	@Test(enabled = true , groups = "atm")
	public void validateSearchForAtmNearYou() {
		atmbranchpage.searchForAtmNearYou("33028");
		WebElement searchResult=  	driver.findElement(By.xpath("//span[@class='ResultSummary-query']"));
		String result = searchResult.getText();
		System.out.println("Search result is : " + result);
		Assert.assertEquals(result, "33028");
	}
	
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
