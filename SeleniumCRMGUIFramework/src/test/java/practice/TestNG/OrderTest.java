package practice.TestNG;

import org.testng.annotations.Test;

public class OrderTest {
		
	
		@Test(invocationCount =10)
		public void createOrderTest() {
			System.out.println("Execute order test ======>123");
		}
		
		@Test(dependsOnMethods ="createOrderTest"  , enabled =false)
		public void billingAndOrderTest() {
			System.out.println("Execute Billing and Order order test ======>123");
		}

}
