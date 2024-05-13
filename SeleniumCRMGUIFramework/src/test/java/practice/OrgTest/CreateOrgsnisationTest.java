package practice.OrgTest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.fileutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrgsnisationTest extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void createorgTest() throws Throwable {
		
		UtilityClassObject.gettest().log(Status.INFO, "reade data from excel");

		String orgname=elib.getDataFromExcel("org",1,0) + jlib.getRandomNumber();

		UtilityClassObject.gettest().log(Status.INFO, "navigate to org Page");
		HomePage hp=new HomePage(driver);
	    hp.getOrgLink().click();
	    
	    UtilityClassObject.gettest().log(Status.INFO, "navigate to creat org page");
	    OrganizationsPage op= new OrganizationsPage(driver);
	    op.getCreateNewOrgBtn().click();
	    
	    UtilityClassObject.gettest().log(Status.INFO, "create new org");
		 CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		 cnop.createorg(orgname);
	    
		
	   //verify header msg Expected result
	    Thread.sleep(5000);
	    OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	   String actorg= oip.getHaedermsg().getText();
	   
	    if(actorg.contains(orgname)) {
	    	System.out.println(orgname+"is ceated=======pass");
	    }else {
	    	System.out.println(orgname+"is not ceated=======fail");
	    }
	
	}
	
	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumber() throws Throwable {
		
		String orgname=elib.getDataFromExcel("org",1,0) + jlib.getRandomNumber();
		String PhoneNumber=elib.getDataFromExcel("contact",7,3) ;
		
		HomePage hp=new HomePage(driver);
	    hp.getOrgLink().click();
	    
	    OrganizationsPage op= new OrganizationsPage(driver);
	    op.getCreateNewOrgBtn().click();
	    
	    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		 cnop.createorgwithPhone(orgname, PhoneNumber);
		 
		 //verfication
		 Thread.sleep(2000);
		 String actPhoneNo=driver.findElement(By.xpath("//td[@class='dvtCellInfo']/span[@id='dtlview_Phone']")).getText();
		 System.out.println(actPhoneNo);
		 if(actPhoneNo.equals(PhoneNumber)) {
			 System.out.println(PhoneNumber+ "is matching");
		 }else {
			 System.out.println(PhoneNumber + "is not matching");
		 }
	    
		
	}

}
