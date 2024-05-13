package practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP2_Test {
	
		
		@Test(dataProvider="getDataFromProvider")
		public void createContactTest(String firstname , String lastname , long phoneNumber) {
			
			System.out.println("FirstName :"+ firstname +", LastName :"+ lastname +" phoneNumber:"+ phoneNumber);
		
		}
		
		@DataProvider
		public Object[][] getDataFromProvider() {
			Object[][] objarr= new Object[3][3];
			objarr[0][0]= "amar";
			objarr[0][1]= "dp";
			objarr[0][2]= 9354029690l;

			
			objarr[1][0]= "divya";
			objarr[1][1]= "prakash";
			objarr[1][2]= 9354029691l;

			objarr[2][0]= "prakash";
			objarr[2][1]= "amar";
			objarr[2][2]= 9354029692l;

			
			return objarr;
			
		}
}
