package practice.TestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		// create an object to eventFiring webdriver
		
		EventFiringWebDriver edri= new EventFiringWebDriver(driver);
		
		// use getscreenshotAs methood to get the file type of screenshot
		File srcFile=edri.getScreenshotAs(OutputType.FILE);
		
		// store sscreenshot in local drive
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
	}

}
