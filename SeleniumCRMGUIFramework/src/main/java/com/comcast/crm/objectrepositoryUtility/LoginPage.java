package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * @author ACER
 * 
 * Contains Login Page element & business lib like Login()
 */

public class LoginPage extends WebDriverUtility{ 
		
	WebDriver driver;
	// constructor 
	
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
        }
	
	//Rule 1 create a seperate java class
	// Rule2 Object creation
	
	
	@FindBy( name="user_name")
   private WebElement usernameEdt;
	
	@FindBy( name="user_password")
	private WebElement passwordEdt;
	
	@FindBy( id="submitButton")
	private WebElement loginbutton;
 
	//Rule3 Object Initialisation in script
	
	// Rule4 Object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	/**
	 * @author ACER
	 * login application based on username password url argumuents
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url ,String username, String password) {
		
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbutton.click();
		
	}
		
	
}
