package practice.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)

public class billTest extends BaseClass {

	
		
			@Test(retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class)
			public void createbillTest() {
				System.out.println("execute create invoice test");
				String acttiltle = driver.getTitle();
				Assert.assertEquals(acttiltle, "Login");
				System.out.println("step--1");
				System.out.println("step--2");
				System.out.println("step--3");
				System.out.println("step--4");
				
			}
			
			@Test
			public void createbilleWithContactTest() {
				System.out.println("execute create invoice with contact test");
				
				
			}
	}



