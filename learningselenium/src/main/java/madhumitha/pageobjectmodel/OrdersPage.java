package madhumitha.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrdersPage {
	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productOrders;
	
	
	public boolean orderHistory(String ProductNames)
	{
		Boolean match=productOrders.stream().anyMatch(products->products.getText().equalsIgnoreCase(ProductNames));
		Assert.assertTrue(match);
		return match;
	}
}
