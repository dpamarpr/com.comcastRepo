package practice.homeTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	
	
	@Test
	public void homePageTest(Method mtd) {
		
		System.out.println(mtd.getName()+ "Test Started");
		
		String Exceptedtitle ="HomePage";
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8888");
	    
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    
	    String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	    
	    // Hard Assert
	   Assert.assertEquals(actTitle, Exceptedtitle);
		System.out.println(mtd.getName()+ "Test stopped");
  	
	}
	
		@Test
		public void VerifyLogoHomePageTest(Method mtd) {
			
		System.out.println(mtd.getName()+ "Test Started");

	    
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8888");
	    
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    
	    boolean status = driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isEnabled();
	    
	 // Hard Assert
	   Assert.assertTrue(status);
	   
		System.out.println(mtd.getName()+ "Test stopped");

	    
	    
	}
}
