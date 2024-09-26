package madhumitha.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import madhumitha.abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	

	//WebElement usrname=driver.findElement(By.id("userEmail"));
	//using pageFactory to find the locators
	// interview question about PageFactory there is a method called initElements which will be write in first it will take care to construct the element using driver parameter.
	@FindBy(id="userEmail")
	WebElement usrname;

	
	//driver.findElement(By.id("userPassword"));
	@FindBy(id="userPassword")
	WebElement pwd;
	
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement submit;
	
	//wrong password
	@FindBy(css="[class*='toast-message']")
	WebElement incorrectpwd;
	
	public void loginPage(String username, String password)
	{
		usrname.sendKeys(username);
		pwd.sendKeys(password);
		submit.click();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMsg()
	{
		waitForElementToAppear(incorrectpwd);
		return incorrectpwd.getText();
	}
}
