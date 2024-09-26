package madhumitha.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//select country options using action class
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryOptions;
	
	//select country
	@FindBy(css=".ta-results button:last-of-type")
	WebElement country;
	
	//click place order button
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeOrderButton;
	
	public void placeOrder(WebDriver driver)
	{
	
	Actions a =new Actions(driver);
    a.sendKeys(countryOptions,"india").build().perform();
   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
    country.click();
    
		placeOrderButton.click();
	}

}
