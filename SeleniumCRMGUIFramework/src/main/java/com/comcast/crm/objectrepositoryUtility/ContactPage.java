package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	// constructor 
	
		public ContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
        }
	
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	
	@FindBy(xpath= "//img[@alt='Create Contact...']")
	private WebElement createcontactBtn;
	
	@FindBy(className ="dvHeaderText")
	private WebElement header;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastname;
	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getCreatecontactBtn() {
		return createcontactBtn;
	}
	
	public WebElement getHeadermsg() {
		return header;
	}
	

}