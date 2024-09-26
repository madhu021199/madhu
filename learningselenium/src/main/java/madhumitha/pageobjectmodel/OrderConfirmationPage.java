package madhumitha.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage {
	
	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//getting thank you text
	@FindBy(css=".hero-primary")
	WebElement ordermsg;
	
	public void orderConfirmation() {

	String confirmMsg=ordermsg.getText();
    System.out.println(confirmMsg);
   Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}
}