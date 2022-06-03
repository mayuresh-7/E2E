package SampleProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.Landingpage;
import pages.Loginpage;
import resources.base;

public class Validations extends base {

	WebDriver driver;
	
	@BeforeTest
	public void invokBrowser() throws IOException{
		driver=initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	

	@Test
	public void Validation() throws IOException {
		

		
		
		Landingpage lp=new Landingpage(driver);
		lp.closetab();
	
		String text =lp.validateCourseText().getText();
		
		
		org.testng.Assert.assertEquals(text, "Featured Courses");
		lp.validateConatactTab();
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	
	

}
