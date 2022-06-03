package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	@FindBy(xpath="//input[@autofocus='autofocus']") private WebElement emaiID;
	@FindBy(xpath="//input[@autocomplete='off']") private WebElement pass;
	@FindBy(xpath="//input[@type='submit']") private WebElement loginbtn;
	
	
	public Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	public WebElement enterEmail() {
		
		return emaiID;
	}
	
	
	public WebElement enterPass() {
		
		return pass;
	}
	
	public void clickLoginbtn() {
		
		loginbtn.click();
	}
}
