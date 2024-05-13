package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener , ISuiteListener {

	
	public static ExtentReports rep= new ExtentReports();
	public  ExtentSparkReporter spark;
	  public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		
//		 TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Report Configration");
		

		
		ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Result");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add envt. info and create test
			rep.attachReporter(spark);
			rep.setSystemInfo("OS", "windows-10");
			rep.setSystemInfo("BROWSER", "CHROME");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report BackUp");
		rep.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("===========>"+result.getMethod().getMethodName()+"===========START======");
		UtilityClassObject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"====started" );

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("===========>"+result.getMethod().getMethodName()+"===========Ends======");
		 test.log(Status.PASS,result.getMethod().getMethodName()+"====Completed" );


	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		TakesScreenshot Edriver = (TakesScreenshot)BaseClass.sdriver;
		String filePath=Edriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		 test.log(Status.FAIL,result.getMethod().getMethodName()+"====Failed" );

 
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		 test.log(Status.SKIP,result.getMethod().getMethodName()+"====Skipped" );

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	
	
	
}
