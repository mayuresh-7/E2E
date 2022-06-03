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




public class TestPage extends base {
	
WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void invokBrowser() throws IOException{
		driver=initializeBrowser();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getdata")
	public void initBrowser(String Username, String Pass) throws IOException {
	
		Landingpage lp=new Landingpage(driver);
		
		lp.closetab();
		lp.loginclk();
		
		Loginpage lg=new Loginpage(driver);
		
		lg.enterEmail().sendKeys(Username);
		lg.enterPass().sendKeys(Pass);
		lg.clickLoginbtn();
		
		log.info(Pass);
		
		
	}
	
	
	@DataProvider
	public Object[][] getdata() {
		
		Object[][] data=new Object[1][2];
		
		data[0][0]="mayuresh@";
		data[0][1]="12345";
		
		return data;
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
