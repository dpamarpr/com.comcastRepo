package practice.OrgTest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class OrganisationCreationTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fu=new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		
		String BROWSER = fu.getDataFromPropertiesFile("browser"); 
		String URL     = fu.getDataFromPropertiesFile("url"); 
		String USERNAME = fu.getDataFromPropertiesFile("username"); 
		String PASSWORD = fu.getDataFromPropertiesFile("password"); 
		
		
		
		int ran =ju.getRandomNumber();
		
		String orgname=eu.getDataFromExcel("Sheet3",1,2) + ran;

		//steps for polymorphism 
		WebDriver driver = null;
		if (BROWSER.equals("Chrome")){
			driver=new ChromeDriver();
		}else if(BROWSER.equals("Edge")) {
			driver= new EdgeDriver();
		}else {
			 driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		// login to application
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(URL,USERNAME , PASSWORD);
		
		/*
		LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		lp.getUsernameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginbutton().click();
	    */
		
		
	  // navigate To Organisation
		
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		
		// click on org btn
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgname);

	
	    //verify header msg Expected result
		OrganizationInformationPage ofp= new OrganizationInformationPage(driver);
		String actOrgName =ofp.getHaedermsg().getText();
		
	   
	    if(actOrgName.contains(orgname)) {
	    	System.out.println(orgname+"is verified=======pass");
	    }else {
	    	System.out.println(orgname+"is not verified=======fail");
	    }
	    
	    hp.logout();
	   
	    
	    
	    
		
	}

}
