package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		
		//step1 : get the java representation object of the physical file
		FileInputStream fis =new FileInputStream("./confiAppData/commontestdata.properties");
		
		//step2: using properties class , load all the keys
		Properties pobj =new Properties();
		pobj.load(fis);
		
		//step3: get the value based on the keys
		System.out.println(pobj.getProperty("browser"));
		System.out.println(pobj.getProperty("url"));
		System.out.println(pobj.getProperty("username"));
		System.out.println(pobj.getProperty("password"));

	}

}
