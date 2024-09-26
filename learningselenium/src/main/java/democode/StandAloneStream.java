package democode;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneStream {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		String ProductNames="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ruthvik@0211");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		System.out.println(products.size());
		WebElement productName=products.stream().filter(s->s.getText().contains(ProductNames)).findFirst().orElse(null);
		productName.findElement(By.cssSelector(".card-body button:last-of-type")).click();


		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();		
		//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		//Thread.sleep(5000);
		List<WebElement> cartProducts=driver.findElements(By.cssSelector("div .cartSection h3"));
		System.out.println(cartProducts.size());
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductNames));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();

       Actions a =new Actions(driver);
       a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india").build().perform();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
       driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click();
       
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
	       System.out.println(confirmMsg);
	      Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	       
	}
}