package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		//create project in FrontEnd using Gui
		String projectname="instagram_91";
		
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://106.51.90.215.:8084/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectname);
		driver.findElement(By.name("createdBy")).sendKeys("Divya Prakash");
		
		Select sel = new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		//verify the project in backEnd using DataBase
		boolean flag= false;
		
		Driver dr= new Driver();
		DriverManager.registerDriver(dr);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects" ,"root@%","root");
		System.out.println("Done");
		
		Statement stat =conn.createStatement();
		
		ResultSet reset=stat.executeQuery("select * from project");
		while(reset.next()) {
			
			//verifing frontend and backend
			
			String projectName1=reset.getString(4);
			if(projectname.equals(projectName1)) {
				flag=true;
			    System.out.println(projectname+"is available");
		}
	}
		if(flag==false) {
		    System.out.println(projectname +"not available");
          }
		
		conn.close();
}
		
		
	}



