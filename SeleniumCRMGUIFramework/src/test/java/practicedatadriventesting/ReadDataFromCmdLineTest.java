package practicedatadriventesting;

import java.time.Duration;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromCmdLineTest {
	
	
	@Test
	public void seleniumTest(XmlTest test) throws EncryptedDocumentException, IOException   {
		
		String URL= System.getProperty("url");
		String BROWSER= System.getProperty("browser");
		String USERNAME= System.getProperty("usrename");
		String PASSWORD= System.getProperty("password");
		
	
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver();}
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();}
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    driver.findElement(By.linkText("Organizations")).click();
		
	    
	    driver.quit();
		
		
	}
	


	
	
	
}
