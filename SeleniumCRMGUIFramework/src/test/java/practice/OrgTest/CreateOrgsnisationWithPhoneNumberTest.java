package practice.OrgTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInformationPage;

public class CreateOrgsnisationWithPhoneNumberTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileUtility fu=new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu= new WebDriverUtility();
		
		HomePage hp =new HomePage(driver);
		DataBaseUtility dlib = new DataBaseUtility();
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		LoginPage      lp   = new LoginPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
		String BROWSER = fu.getDataFromPropertiesFile("browser"); 
		String URL     = fu.getDataFromPropertiesFile("url"); 
		String USERNAME = fu.getDataFromPropertiesFile("username"); 
		String PASSWORD = fu.getDataFromPropertiesFile("password"); 
		
		
		int ran=ju.getRandomNumber();
		String orgname=eu.getDataFromExcel("Sheet3",1,2) + ran;
		String PhoneNo=eu.getDataFromExcel("Sheet3",7,3);
			
		
		//steps for polymorphism 
		WebDriver driver1 = null;
		if (BROWSER.equals("Chrome")){
			driver1=new ChromeDriver();
		}else if(BROWSER.equals("Edge")) {
			driver1= new EdgeDriver();
		}else {
			 driver1=new ChromeDriver();
		}
		wu.waitForPageToLoad(driver);
		driver1.get(URL);
		
		lp.loginToApp(URL, USERNAME, PASSWORD);
		
		cnop.createorg(orgname, PhoneNo);
	   

	    driver1.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //verify ActualPhoneNo. With Expected result
	    String ActualPhone=driver1.findElement(By.id("dtlview_Phone")).getText();
	    if(ActualPhone.contains(PhoneNo)) {
	    	System.out.println(PhoneNo+"is ceated=======pass");
	    }else {
	    	System.out.println(PhoneNo+"is not ceated=======fail");
	    }
	    
	    
	    
	    driver1.quit();
		
	}

}
