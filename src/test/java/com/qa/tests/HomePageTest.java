package com.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseTest;
import com.qa.pages.AtmBranchPage;
import com.qa.pages.EspanolPage;
import com.qa.pages.HomePage;
import com.qa.pages.SearchPage;

public class HomePageTest extends BaseTest {

	public HomePage homepage;
	public AtmBranchPage atmbranchpage;
	public SearchPage searchpage;
	public EspanolPage espanolpage;
	
   SoftAssert softassert = new SoftAssert();
   
   public HomePageTest() {
	   super();
   }
	@BeforeMethod
	public void setup() {
		initialize();

		homepage = new HomePage();
		atmbranchpage = new AtmBranchPage();
		searchpage = new SearchPage();
		espanolpage = new EspanolPage();

	}

	@Test(priority = 1, enabled = true, groups = "homepage")
	public void verifyHomePageLogoTest() {
		boolean logo = homepage.visibilityOfHomePageLogo();
		softassert.assertTrue(logo);
		softassert.assertAll();
	}

	@Test(priority = 2, enabled = true, groups = "homepage")
	public void validateHomePageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Home page title is : " + title);
		Assert.assertEquals(title, "Credit Card, Mortgage, Banking, Auto | Chase Online | Chase.com",
				"Title does not match expected result");
	}

	@Test(priority = 3, enabled = true, groups = {"atm","homepage"})
	public void validateAtmBranchTabTest() {
		atmbranchpage = homepage.clickATMandBranch();
		String AtmBranchTitle = driver.getTitle();
		System.out.println("ATM page title is : " + AtmBranchTitle);
		Assert.assertEquals(AtmBranchTitle, "Find a Chase ATM or branch near you | Chase Bank",
				"Title does not match expected result");
	}

	@Test(priority = 4, enabled = true, groups = {"homepage","search"})
	public void verifySearchTest() {
		searchpage = homepage.doSearch("cash");
		String SearchTitle = driver.getTitle();
		System.out.println("Search page title is : " + SearchTitle);

		Assert.assertEquals(SearchTitle, "Search | Chase | Chase.com", "Title does not match expected result");

	}

	@Test(priority = 5, enabled = false)
	public void verifyEspanolTabTest() {
		espanolpage = homepage.clickEspanolTab();
		String EspanolTitle = driver.getTitle();
		System.out.println("Espanol page title is : " + EspanolTitle);

		Assert.assertEquals(EspanolTitle, "Tarjeta de crédito, hipoteca, banca, vehículo | Chase Online | chase.com",
				"Title does not match expected result");

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
