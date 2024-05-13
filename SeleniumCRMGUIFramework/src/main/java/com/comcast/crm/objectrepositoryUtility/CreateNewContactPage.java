package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnametxtfld;
	
	@FindBy (xpath= "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name= "support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(id="homephone")
	private WebElement phoneNo;

	
	public WebElement getFirstnametxtfld() {
		return lastnametxtfld;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}
	

	public WebElement getStartDate() {
		return startDate;
	}


	public WebElement getEndDate() {
		return endDate;
	}


	public WebElement getPhoneNo() {
		return phoneNo;
	}
	
	public void createContact(String name) {
		lastnametxtfld.sendKeys(name);
		getSavebtn().click();
		
   }
	
	public void createContactWithDate(String name , String startdate,String enddate) {
		lastnametxtfld.sendKeys(name);
		startDate.sendKeys(startdate);
		endDate.sendKeys(enddate);
		savebtn.click();
		
   }
	
	
}