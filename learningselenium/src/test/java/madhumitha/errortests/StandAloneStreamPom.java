package madhumitha.errortests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import madhumitha.pageobjectmodel.AddToCartPage;
import madhumitha.pageobjectmodel.CheckOutPage;
import madhumitha.pageobjectmodel.OrderConfirmationPage;
import madhumitha.pageobjectmodel.OrdersPage;
import madhumitha.pageobjectmodel.ProductCatalogue;
import madhumitha.testcomponents.BaseTest;



public class StandAloneStreamPom extends BaseTest{

	String ProductNames="ZARA COAT 3";
	@Test()
	public void submitOrderTest() throws IOException {
		// TODO Auto-generated method stub

		
		
		//launchApplication();
		lp.loginPage("abcd@gmail.com","Ruthvik@0211");
		
		ProductCatalogue productcatalogue= new ProductCatalogue(driver);
		List<WebElement> products=productcatalogue.getProductsList();
		
		productcatalogue.getProductByName(ProductNames);
		productcatalogue.addToCart(ProductNames);
		productcatalogue.clickCartImage();

        AddToCartPage atcp =new AddToCartPage(driver);
        atcp.getCartItems(ProductNames);
	

        CheckOutPage cop=new CheckOutPage(driver);
        cop.placeOrder(driver);
		
        
        OrderConfirmationPage ocp=new OrderConfirmationPage(driver);
        ocp.orderConfirmation();
	}
	
	@Test(dependsOnMethods= {"submitOrderTest"})
	public void orderTest() throws IOException
	{
		//launchApplication();
		lp.loginPage("abcd@gmail.com","Ruthvik@0211");
		lp.goToOrderPage();
		OrdersPage op=new OrdersPage(driver);
		Assert.assertTrue(op.orderHistory(ProductNames));
	}
}