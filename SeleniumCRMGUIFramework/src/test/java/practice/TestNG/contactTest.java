package practice.TestNG;

import org.testng.annotations.Test;

public class contactTest {
	
		@Test
		public void createContactTest() {
			
			System.out.println("execute create test");
		}
		
		@Test(dependsOnMethods = "createContactTest")
		public void modifyCreateContactTest() {
			
			System.out.println("execute modify create contact test");
		}

		@Test(dependsOnMethods="modifyCreateContactTest")
		public void DeleteCreateContactTest() {
			
			System.out.println("execute delete create contact test");
		}
}
