package practice.Test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.BaseClass;

public class SampleReportTest  extends BaseClass{
	
	public ExtentReports rep= new ExtentReports();
	public ExtentTest test;
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
		
		//spark report config
	
		
		ExtentTest test = rep.createTest("CreatecontactTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL, "contact is not created");
		
		}
		
	}
	
	
	@Test
	public void CreatecontactwithOrganiTest() {
		
		//spark report config
	
		
		 test = rep.createTest("CreatecontactwiithOrganiTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL, "contact is not created");
		
		}
		
	}
	
	
	@Test
	public void CreatecontactwithPhoneTest() {
		
		//spark report config
	
		
		ExtentTest test = rep.createTest("CreatecontactwithPhoneTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL, "contact is not created");
		
		}
		
	}
	
	

}
