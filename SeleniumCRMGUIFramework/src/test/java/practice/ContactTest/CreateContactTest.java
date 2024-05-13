package practice.ContactTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.fileutility.BaseClass;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;

public class CreateContactTest extends BaseClass {
	
	@Test(groups = "smokeTest")
	public  void createContactTest() throws Throwable {
		
		ContactPage cp= new ContactPage(driver);
		
		String lastName1 = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		HomePage hp= new HomePage(driver);
		hp.getContactsLink().click();
		hp.getCreatecontactBtn().click();		
		CreateNewContactPage cncp =new CreateNewContactPage(driver);
		cncp.createContact(lastName1);
				
		String header= cp.getHeadermsg().getText();

		boolean status=header.contains(lastName1);
		Assert.assertEquals(status, true);
		
		String actlastname= cp.getLastname().getText();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actlastname, lastName1);
		
	}

	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Throwable {
		
		String lastName1 = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		HomePage hp= new HomePage(driver);
		hp.getContactsLink().click();
		hp.getCreatecontactBtn().click();		
		
				
		String StartDate = jlib.getSystemDateYYYYDDMM();
		String EndDate = jlib.getRequiredDateYYYYDDMM(30);
		
		
		CreateNewContactPage cnp =new CreateNewContactPage(driver);
		cnp.createContactWithDate(lastName1, StartDate, EndDate);
		
		Thread.sleep(2000);
		String actstrtdate= cnp.getStartDate().getText();
		String actEndDate =cnp.getEndDate().getText();
		
		boolean status=actstrtdate.contains(StartDate);
		Assert.assertEquals(status, true);
		
		
		
		boolean status2 =actEndDate.contains(EndDate);
		Assert.assertEquals(status2, true);
		
		

	}
}
