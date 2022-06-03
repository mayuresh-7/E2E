package pages;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	@FindBy(xpath="//div[@style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']") private WebElement closetab;    
	@FindBy(xpath="//span[text()='Login']") private WebElement loginbtn;
	@FindBy(xpath="//h2[text()='Featured Courses']") private WebElement courseText;
	@FindBy(xpath="//a[text()='Contact']") private WebElement tabContact;
	
	
	public Landingpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void closetab() {
		closetab.click();
	}
	

	public void loginclk() {
		
		loginbtn.click();
	}
	
	public WebElement validateCourseText() {
		
		return courseText;
	}
	
	public void validateConatactTab() {
		
		Assert.assertTrue("Tab is Present", tabContact.isDisplayed());
		
	}
}
