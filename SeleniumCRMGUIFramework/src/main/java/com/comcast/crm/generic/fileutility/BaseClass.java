package com.comcast.crm.generic.fileutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class BaseClass {
		
		public WebDriver driver=null;
		public static WebDriver sdriver;
		public DataBaseUtility dlib = new DataBaseUtility();
		public FileUtility    fLib = new FileUtility();
		public ExcelUtility elib = new ExcelUtility();
		public JavaUtility jlib = new JavaUtility();
		public WebDriverUtility wlib = new WebDriverUtility();
		public CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		public HomePage hp =new HomePage(driver);
		public OrganizationsPage op= new OrganizationsPage(driver);
		public LoginPage      lp   = new LoginPage(driver);
		public OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
		
		@BeforeSuite(groups={"smokeTest" , "regresiionTest"})
		public void configBS() throws SQLException {
			System.out.println("connect to dataBase and report config");
			dlib.getDBConnection();

		}
		
//		@Parameters("BROWSER")
		@BeforeClass(groups={"smokeTest" , "regresiionTest"})
		public void configBC(/* String browser*/) throws IOException {
			System.out.println("===Launch the Browser===");

			String BROWSER=
					fLib.getDataFromPropertiesFile("browser");
			
			
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver(); }
			else if (BROWSER.equals("edge")) {
				driver= new EdgeDriver();
			}else if (BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			
			else { 
				driver= new ChromeDriver();
			}
			sdriver=driver;
			UtilityClassObject.setDrivert(driver);
		
		}
		
		@BeforeMethod(groups={"smokeTest" , "regresiionTest"})
		public void confihBM() throws Throwable {
			System.out.println("==Login to application==");


			String USERNAME=fLib.getDataFromPropertiesFile("username");
			String PASSWORD=fLib.getDataFromPropertiesFile("password");
			String URL=fLib.getDataFromPropertiesFile("url");
			System.out.println(URL);
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(URL, USERNAME, PASSWORD);
		}
		
		@AfterMethod(groups={"smokeTest" , "regresiionTest"})
		public void configAM() {
			System.out.println("==Logout from application==");

			HomePage hp =new HomePage(driver);
			hp.logout();
		}
		
		@AfterClass(groups={"smokeTest" , "regresiionTest"})
		public void cnofigAC() {
			System.out.println("==Close the Browser==");

			driver.quit();
		}
		
		@AfterSuite(groups={"smokeTest" , "regresiionTest"})
		public void configAS() throws SQLException {
			System.out.println("close dataBase and report backup");

			dlib.closeDBConnection();

		}

}
