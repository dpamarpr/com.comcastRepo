package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class integratedExecutionOfSelenium {
	
	@Test
	public void seleniumTest() throws EncryptedDocumentException, IOException {
		String BROWSER= System.getProperty("browser");
		String URL= System.getProperty("url");
		String USERNAME= System.getProperty("usrename");
		String PASSWORD= System.getProperty("password");
		
		Random rd=new Random();
		int ran=rd.nextInt(1000);
		
		FileInputStream fis= new FileInputStream("./TestData/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet3");
		String row=sh.getRow(1).getCell(0).getStringCellValue()+ran;
		

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
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(row);
	    driver.findElement(By.name("button")).click();
		
	    
	    driver.quit();
		
	}
}


