package practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
		
		@Test(dataProvider="getDataFromProvider")
		public void createContactTest(String firstname , String lastname) {
			
			System.out.println("FirstName :"+ firstname +", LastName :"+ lastname);
		
		}
		
		@DataProvider
		public Object[][] getDataFromProvider() {
			Object[][] objarr= new Object[3][2];
			objarr[0][0]= "amar";
			objarr[0][1]= "dp";
			
			objarr[1][0]= "divya";
			objarr[1][1]= "prakash";
			
			objarr[2][0]= "prakash";
			objarr[2][1]= "amar";
			
			return objarr;
			
		}
}
