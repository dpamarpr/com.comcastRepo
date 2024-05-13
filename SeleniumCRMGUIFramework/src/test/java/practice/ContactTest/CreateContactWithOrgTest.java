package practice.ContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

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
		
		String orgname=eu.getDataFromExcel("contact",10,2) + ran;
		String lastname=eu.getDataFromExcel("contact",10,3) + ran;


		
		

		//steps for polymorphism 
		WebDriver driver = null;
		if (BROWSER.equals("Chrome")){
			driver=new ChromeDriver();
		}else if(BROWSER.equals("Edge")) {
			driver= new EdgeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			 driver=new ChromeDriver();
		}
		
		wu.waitForPageToLoad( driver);		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //verify header msg Expected result
	    String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headerInfo.contains(orgname)) {
	    	System.out.println(orgname+"is ceated=======pass");
	    }else {
	    	System.out.println(orgname+"is not ceated=======fail");
	    }
	    // verify the header orgname info Expected Result
	    String actulorgNameInfo=driver.findElement(By.id("dtlview_Organization Name")).getText();
	    if(actulorgNameInfo.equals(orgname)) {
	    	System.out.println(orgname+"is ceated=======pass");
	    }else {
	    	System.out.println(orgname+"is not ceated=======fail");
	    }
	    
	    //navigate to contact module
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys(lastname);	    
	    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	    
	    //switch to child window
	    wu.switchNewBrowser(driver,"module=Accounts");
	    wu.switchToTabOnUrl(driver,"switchToTabOnUrl");
	    driver.findElement(By.name("search_text")).sendKeys(orgname);
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	
	    wu.switchToTabOnUrl(driver,"switchToTabOnUrl");


      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      	
   // verify the header orgname info Ecpected Result
	    String actullastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
	    System.out.println(actullastName);
	    if(actullastName.trim().equals(lastname)) {
	    	System.out.println(lastname+"is ceated=======pass");
	    }else {
	    	System.out.println(lastname+"is not ceated=======fail");
	    }
	    
	    driver.quit();
		
	
	}

}
