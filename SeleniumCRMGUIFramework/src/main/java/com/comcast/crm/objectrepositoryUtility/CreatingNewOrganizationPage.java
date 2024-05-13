package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDB;
	
	@FindBy(id="phone")
	private WebElement PhoneNum;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement strtdatemsg;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement enddatemsg;
	
	public WebElement getEnddatemsg() {
		return enddatemsg;
	}
	
	public WebElement getStrtdatemsg() {
		return strtdatemsg;
	}
	
	public WebElement getorgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustry() {
		return industryDB;
	}
	
	public WebElement getPhoneNum() {
		return PhoneNum;
	}

	
	public void createorg(String orgname) {
		
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void createorg(String orgname ,String industry) {
		
		orgNameEdt.sendKeys(orgname);
		Select sel= new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}

	
	
public void createorgwithPhone(String orgname , String phonenumber) {
		
		orgNameEdt.sendKeys(orgname);
		PhoneNum.sendKeys(phonenumber);
		saveBtn.click();
	}


	
	


}
