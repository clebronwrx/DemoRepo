package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class HomePage extends BaseTest {

	// OBJECT REPOSITORY
	@FindBy(xpath = "//a[@class='header__section--center--link chaseanalytics-track-link']")
	WebElement logo;
	@FindBy(xpath = "//a[@class='header__section--dropdown__title__link chaseanalytics-track-link']")
	WebElement openAccntDropDwn;
	@FindBy(xpath = "//input[@name='userId']")
	WebElement userId;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@id='signin-button']")
	WebElement signinBtn;
	@FindBy(xpath = "//a[@data-pt-name='hd_atmbranch']")
	WebElement atmBranchTab;
	@FindBy(xpath = "//a[@data-pt-name='hd_espanol']")
	WebElement espanolTab;
	@FindBy(xpath = "//a[@class='header__section__item header__section--search icon-search']")
	WebElement searchBtn;
	@FindBy(xpath = "//input[@class='header__section--search__bar--search-input']")
	WebElement searchField; // hit enter on element

	// page Actions
	public boolean visibilityOfHomePageLogo() {
		boolean flag = logo.isDisplayed();
		return flag;
	}

	public void enterCredentials() {
		userId.sendKeys("chris123@gmail.com");
		password.sendKeys("admin@123");
		signinBtn.click();

	}

	public AtmBranchPage clickATMandBranch() {
		atmBranchTab.click();
		return new AtmBranchPage();
	}

	public EspanolPage clickEspanolTab() {
		espanolTab.click();
		return new EspanolPage();
	}

	public SearchPage doSearch(String s) {
		searchBtn.click();
		if (searchField.isDisplayed()) {
			searchField.sendKeys(s);
		}

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		return new SearchPage();
	}

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
