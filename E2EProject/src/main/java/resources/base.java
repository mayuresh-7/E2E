package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {
		 prop= new Properties();
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\workstuff\\E2EProject\\src\\main\\java\\resources\\data.properties");
	
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		String urlname=prop.getProperty("url");
		
		
		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Automation\\Chrome_driver_jar\\chromedriver_win32 (102)\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		 
		}
		else {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Documents\\Automation\\Chrome_driver_jar\\Firefox_browser\\geckodriver.exe");
	
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	
	}
	
	
	public String takeScreenshot(String testname, WebDriver driver) throws IOException {
	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path="C:\\Users\\Admin\\Documents\\Automation\\screenshots\\"+testname+".png";
		
		File dest= new File(path);
		
		FileUtils.copyFile(src, dest);
		
		return path;
		

				
	}
}
