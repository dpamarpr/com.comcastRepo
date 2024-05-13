package practiceDtaBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		
		try {
		//load /register database driver
		Driver dr= new Driver();
		DriverManager.registerDriver(dr);
		
		//connect to databasedriver
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" ,"root","root");
		System.out.println("Done");
		
		//create sql statement
		Statement stat =conn.createStatement();
		
		//execute query & get all result
		ResultSet Reset=stat.executeQuery("Select * from project");
		while(Reset.next()) {
			System.out.println(Reset.getString(1));
		}
		}
		catch(Exception e) {
		System.out.println("handled exception");
		
	}
		finally {
			//close the connection
			conn.close();
			
		}

}
}
