package practice.homeTest;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	
	
	@Test
	public void homePageTest(Method mtd) {
		
		Reporter.log(mtd.getName()+ "Test Started");
		
		SoftAssert sa = new SoftAssert();
		Reporter.log("Step-------1", true);
		Reporter.log("Step-------2", true);
		
		sa.assertEquals("Home", "Home");
		Reporter.log("Step-------3", true);
		sa.assertEquals("Home--CRM", "Home--CRM");

		Reporter.log("Step-------4",true);
		sa.assertAll();
		Reporter.log(mtd.getName()+ "Test stopped");
  	
	}
	
		@Test
		public void VerifyLogoHomePageTest(Method mtd) {
			
		Reporter.log(mtd.getName()+ "Test Started");
		SoftAssert sa = new SoftAssert();

	    
		Reporter.log("Step-------1", true);
		Reporter.log("Step-------2", true);
		sa.assertTrue(true);
		Reporter.log("Step-------3", true);
		Reporter.log("Step-------4", true);
		sa.assertAll();
		
	   
		Reporter.log(mtd.getName()+ "Test stopped");

	    
	    
	}
}
