package practiceDtaBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class executenonselectquery {

	public static void main(String[] args) throws SQLException {
			
		
		//load /register database driver
				Driver dr= new Driver();
				DriverManager.registerDriver(dr);
				
				//connect to databasedriver
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" ,"root","root");
				System.out.println("Done");
				
				//create sql statement
				Statement stat =conn.createStatement();
				
				//execute update & get all result
				int result = stat.executeUpdate("insert into project values('TY_124','Divya Prakash','04/04/12','FB','Ongoing',100)");
				System.out.println(result);
				
				//close the database
				conn.close();
				}
	}


