package practicedatadriventesting;

import org.testng.annotations.Test;

public class readrunTimeParameterTest {
		
		@Test
		public void runtimeParameterTest() {
			String URL= System.getProperty("url");
			String BROWSER= System.getProperty("browser");
			String USERNAME= System.getProperty("usrename");
			String PASSWORD= System.getProperty("password");
			
			System.out.println(URL);
			System.out.println(BROWSER);
			System.out.println(USERNAME);
			System.out.println(PASSWORD);
		}
}
