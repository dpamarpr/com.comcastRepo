package practice.amazone.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GetProductInfoInAmazone {
	
	@Test(dataProvider ="getdata")
	public void getProductInfoTest(String brandName , String productName) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		
		String x= "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable{
		
		ExcelUtility Elib= new ExcelUtility();
		int rowCount=Elib.getLastRowCount("product");
		
		Object[][] obarr = new Object[rowCount][2];
		
		for(int i = 0; i<rowCount ; i++) {
		obarr[i][0]=Elib.getDataFromExcel("product",i+1, 0);
		obarr[i][1]=Elib.getDataFromExcel("product",i+1, 1);
		}
		
		return obarr;
		
	}

}
