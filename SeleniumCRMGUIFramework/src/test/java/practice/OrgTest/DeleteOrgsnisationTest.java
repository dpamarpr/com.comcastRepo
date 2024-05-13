package practice.OrgTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class DeleteOrgsnisationTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fu=new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		
		String BROWSER = fu.getDataFromPropertiesFile("browser"); 
		String URL     = fu.getDataFromPropertiesFile("url"); 
		String USERNAME = fu.getDataFromPropertiesFile("username"); 
		String PASSWORD = fu.getDataFromPropertiesFile("password"); 
		
		
		
		int ran =ju.getRandomNumber();
		
		String orgname=eu.getDataFromExcel("contact",19,2) + ran;

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	   
	    
	    // create Organisation
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //verify header msg Expected result
	    Thread.sleep(5000);
	    String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headerInfo.contains(orgname)) {
	    	System.out.println(orgname+"is ceated=======pass");
	    }else {
	    	System.out.println(orgname+"is not ceated=======fail");
	    }
	    // verify the header orgname info Ecpected Result
	    String actulorgNameInfo=driver.findElement(By.id("dtlview_Organization Name")).getText();
	    if(actulorgNameInfo.equals(orgname)) {
	    	System.out.println(orgname+"is ceated=======pass");
	    }else {
	    	System.out.println(orgname+"is not ceated=======fail");
	    }
	    
	    //go back to organisation Page
	    
	    
	    HomePage hp=new HomePage(driver);
	    hp.getOrgLink().click(); 
	  
	    
	    OrganizationsPage orgP = new OrganizationsPage(driver);
	    
	    orgP.getSearchbox().sendKeys(orgname);
	    wu.select(orgP.getSearchdropDown(),"Organization Name");
	    orgP.getSearchnowbtn().click();
	    
	    
	    
	    //In dymanic Webtable Select And Delete Organisation
	    
	    driver.findElement(By.xpath("//a[text()='"+orgname+"']/../..//a[text()='del']")).click();
	    
	    //to Handle Alert
        
	    wu.switchtoAlert(driver);
	    
	    driver.quit();
		
	}

}
