package practice.OrgTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrgsnisationWithIndustriesTest2 {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fu=new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();;
		
		String BROWSER = fu.getDataFromPropertiesFile("browser"); 
		String URL     = fu.getDataFromPropertiesFile("url"); 
		String USERNAME = fu.getDataFromPropertiesFile("username"); 
		String PASSWORD = fu.getDataFromPropertiesFile("password"); 
		
		int ran=ju.getRandomNumber();
		
		String orgname=eu.getDataFromExcel("Sheet3",4,2) + ran;
		String industry=eu.getDataFromExcel("Sheet3",4,3);
		String type=eu.getDataFromExcel("Sheet3",4,4);
		
		

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
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    driver.findElement(By.name("accountname")).sendKeys(orgname);

	    WebElement wbsel =driver.findElement(By.name("industry"));
	    Select sel=new Select(wbsel);
	    sel.selectByVisibleText(industry);
	    

	    WebElement wbsel1 =driver.findElement(By.name("accounttype"));
	    Select sel1=new Select(wbsel1);
	    sel1.selectByVisibleText(type);
	    		
	    		
	    
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //verify induatry msg Expected result
	    String actualIndus=driver.findElement(By.id("dtlview_Industry")).getText();
	    if(actualIndus.contains(industry)) {
	    	System.out.println(industry+"is ceated=======pass");
	    }else {
	    	System.out.println(industry+"is not ceated=======fail");
	    }
	    // verify the header orgname info Ecpected Result
	    
	    String actulTypeInfo=driver.findElement(By.id("dtlview_Type")).getText();
	    if(actulTypeInfo.equals(type)) {
	    	System.out.println(type+"is ceated=======pass");
	    }else {
	    	System.out.println(type+"is not ceated=======fail");
	    }
	    
	    
	    driver.quit();
		
	}

}
