package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindBy(name="search_text")
	private WebElement searchbox;
	
	@FindBy(name="search_field")
	private WebElement searchdropDown;
	
	@FindBy(name="submit")
	private WebElement searchnowbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchdropDown() {
		return searchdropDown;
	}


	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}

}
