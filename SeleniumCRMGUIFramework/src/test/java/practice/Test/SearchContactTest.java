package practice.Test;

import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.BaseClass;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

/**
 * 
 * test class for contact module
 * @author ACER
 */
public class SearchContactTest extends BaseClass {
	/*
	 * scenarion : login()===>navigateContact=====>createContact()====>verify
	 */
	 
	
	@Test
	public void searchContact() {
		
		/* Step 1 Login to application */
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("url", "username", "pasword");
	}

}
