package practice.Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.BaseClass;

public class SampleReportAndScreenSohotTest  /*extends BaseClass*/{
	
	public ExtentReports rep= new ExtentReports();

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add envt. info and create test
		rep.attachReporter(spark);
		rep.setSystemInfo("OS", "windows-10");
		rep.setSystemInfo("BROWSER", "CHROME");
		
	}
	

	@Test
	public void CreatecontactTest() {
		
		//screnshot 
		
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot Edriver = (TakesScreenshot)driver;
		String filePath=Edriver.getScreenshotAs(OutputType.BASE64);
		
		
	
	
		//spark report config
		ExtentTest test = rep.createTest("CreatecontactTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HDFG")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		
		}
		
		driver.close();
		
	}
	
	@AfterSuite
	public void configAS() {
		rep.flush();
	}

	

}
