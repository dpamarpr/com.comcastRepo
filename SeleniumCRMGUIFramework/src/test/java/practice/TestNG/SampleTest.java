package practice.TestNG;

import org.testng.annotations.Test;

public class SampleTest {

	
		@Test
		public void createContactTest() {
			System.out.println("Contact created");
		}
		
		@Test
		public void createContactWithMobileNumberTest() {
			System.out.println("Contact created With Mobile Number");
		}
}
