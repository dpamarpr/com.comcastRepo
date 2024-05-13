package com.crm.genericbaseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
		@BeforeSuite
		public void configBS() {
			System.out.println("connect to dataBase and report config");
		}
	
		@BeforeClass
		public void configBC() {
			System.out.println("===Launch the Browser===");
		}
		
		@BeforeMethod
		public void confihBM() {
			System.out.println("==Login to application==");
		}
		
		@AfterMethod
		public void configAM() {
			System.out.println("==Logout from application==");
		}
		
		@AfterClass
		public void cnofigAC() {
			System.out.println("==Close the Browser==");
		}
		
		@AfterSuite
		public void configAS() {
			System.out.println("close dataBase and report backup");
		}

}
