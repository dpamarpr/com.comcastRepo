 package com.comcast.crm.objectrepositoryUtility;

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
			public HomePage(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslink
	;
	
	@FindBy(xpath= "//img[@title='Create Contact...']")
	private WebElement createcontactBtn;

	public WebElement getContactsLink() {
		return contactslink;
	}

	public WebElement getCreatecontactBtn() {
		return createcontactBtn;
	}
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public void navigateToCampaingPage() {
		Actions action= new Actions(driver);
		action.moveToElement(moreLink).perform();
		campaignsLink.click();
	}
	
	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(adminimg).perform();
		signoutLink.click();
	}


}
