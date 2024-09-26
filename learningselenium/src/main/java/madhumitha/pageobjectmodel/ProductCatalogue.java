package madhumitha.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import madhumitha.abstractcomponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
//driver.findElements(By.cssSelector(".mb-3"))
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//for cartImage
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartbutton;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	By animation=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductsList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
   
	public WebElement getProductByName(String ProductName)
	{
		WebElement productName=getProductsList().stream().filter(s->s.getText().contains(ProductName)).findFirst().orElse(null);
		return productName;
	}
	
	public void addToCart(String ProductName)
	{
		WebElement prod=getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toast);
		waitForElementToDisAppear(animation);
	}
	public void clickCartImage()
	{
		cartbutton.click();		
	}
	
}