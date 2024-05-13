package practiceDtaBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	
		@Test
		public void projectCheckTestCase() throws SQLException {
			String expectedProject= "FB";
			boolean flag= false;
			
			Driver dr= new Driver();
			DriverManager.registerDriver(dr);
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" ,"root","root");
			System.out.println("Done");
			
			Statement stat =conn.createStatement();
			
			ResultSet reset=stat.executeQuery("select * from project");
			while(reset.next()) {
				String projectName=reset.getString(2);
				if(expectedProject.equals(projectName)) {
					flag=true;
				    System.out.println(expectedProject+"is available");
			}
		}
			if(flag==false) {
			    System.out.println(expectedProject +"not available");
              }
			
			conn.close();
    }
		
}