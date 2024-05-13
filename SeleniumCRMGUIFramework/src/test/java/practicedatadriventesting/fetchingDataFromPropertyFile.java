package practicedatadriventesting;


import java.io.FileInputStream;
import java.util.Properties;

public class fetchingDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis =new FileInputStream("./confiAppData/commontestdata.properties");
		
		Properties Prop=new Properties();
		Prop.load(fis);
		
		String BROWSER =Prop.getProperty("browser");
		String URL     = Prop.getProperty("url");
		String USERNAME = Prop.getProperty("username");
		String PASSWORD =Prop.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

	}

}
 