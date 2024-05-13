package practicedatadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) throws Throwable {
		
	
	FileInputStream fis =new FileInputStream("./confiAppData/commontestdata.properties");
	
	Properties prop =new Properties();
	prop.load(fis);
	
	String BROWSER = prop.getProperty("browser"); 
	String URL     = prop.getProperty("url"); 
	String USERNAME = prop.getProperty("username"); 
	String PASSWORD = prop.getProperty("password"); 
	

	//steps for polymorphism 
	WebDriver driver = null;{
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
    driver.findElement(By.name("accountname")).sendKeys("amar"
    		);
    driver.findElement(By.name("button")).click();
    
    Actions action=new Actions(driver);
    action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click();
    action.moveToElement(driver.findElement(By.linkText("Sign Out"))).click();
	
    
    driver.quit();
	}
	
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	

