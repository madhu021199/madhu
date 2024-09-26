package madhumitha.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage {
	
	WebDriver driver;
public AddToCartPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}


//checking cartitems
@FindBy(css="div .cartSection h3")
List<WebElement> cartProducts;

//click checkout button on AddToCartPage
@FindBy(css=".totalRow button")
WebElement checkoutbutton;

public void getCartItems(String ProductName)
{

	System.out.println(cartProducts.size());
	Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
	Assert.assertTrue(match);
	checkoutbutton.click();
	
}
}
