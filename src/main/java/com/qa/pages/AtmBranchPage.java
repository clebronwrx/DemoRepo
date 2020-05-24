package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class AtmBranchPage extends BaseTest {

	
	public AtmBranchPage() {
		PageFactory.initElements(driver, this);
	}
	//object repository
	@FindBy(id="q") WebElement searchField;
	@FindBy(xpath="//button[@class='search-button']") WebElement searchBtn ;
	@FindBy(xpath = "//a[contains(text(),'Find an advisor')]") WebElement findAdvisor;
	@FindBy(xpath = "//a[contains(text(),'Find an office')]") WebElement findAnOffice;
	@FindBy(linkText = "Schedule a meeting") WebElement scheduleMeeting;
	@FindBy(xpath = "//div[text()=('International ATMs')]//following-sibling::div//child::a") WebElement internationalAtm;
	
	//page actions
	public void searchForAtmNearYou(String location) {
		searchField.sendKeys(location);
		searchBtn.click();
		
		
		
	}
	public void clickOnFindAdvisor() {
		findAdvisor.click();
	}
	public void clickOnFindOffice() {
		findAnOffice.click();
	}
	public void clickScheduleMeeting() {
		scheduleMeeting.click();
	}
	public void clickInternationalAtm() {
		internationalAtm.click();
	}
	
	
}
