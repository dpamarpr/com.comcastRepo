package practice.ContactTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		
		
		FileUtility fu=new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();;
		
		String BROWSER = fu.getDataFromPropertiesFile("browser"); 
		String URL     = fu.getDataFromPropertiesFile("url"); 
		String USERNAME = fu.getDataFromPropertiesFile("username"); 
		String PASSWORD = fu.getDataFromPropertiesFile("password"); 
		
		
		String lastname =eu.getDataFromExcel("contact",10,2) + ju.getRandomNumber();
		
		
		

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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    
	   String startDate=ju.getSystemDateYYYYDDMM();
	   String endDate=ju.getRequiredDateYYYYDDMM(30);
	    
	    driver.findElement(By.name("lastname")).sendKeys(lastname);
	    driver.findElement(By.name("support_start_date")).clear();
	    driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	    
	    driver.findElement(By.name("support_end_date")).clear();
	    driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	   
	    
	    
	    //verify header msg Expected result
	    String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(headerInfo.contains(lastname)) {
	    	System.out.println(lastname+"is ceated=======pass");
	    }else {
	    	System.out.println(lastname+"is not ceated=======fail");
	    }
	    // verify the lastname info Ecpected Result
	    String actullastNameInfo=driver.findElement(By.id("dtlview_Last Name")).getText();
	    if(actullastNameInfo.equals(lastname)) {
	    	System.out.println(lastname+"is ceated=======pass");
	    }else {
	    	System.out.println(lastname+"is not ceated=======fail");
	    }
	    
	    String actualstartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
	    if(actualstartDate.equals(startDate)) {
	    	System.out.println(startDate+"is ceated=======pass");
	    }else {
	    	System.out.println(startDate+"is not ceated=======fail");
	    }
	    
	    String actualendDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
	    if(actualendDate.equals(endDate)) {
	    	System.out.println(endDate+"is ceated=======pass");
	    }else {
	    	System.out.println(endDate+"is not ceated=======fail");
	    }
	    
	    
	    driver.quit();
		
	}

}
