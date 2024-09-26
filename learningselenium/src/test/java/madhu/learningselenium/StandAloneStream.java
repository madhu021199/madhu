package madhu.learningselenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneStream {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String expectedItems[] = {"ZARA COAT 3","ADIDAS ORIGINAL"};
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ruthvik@0211");
		driver.findElement(By.id("login")).click();
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		List<WebElement> productsName=driver.findElements(By.xpath("//div[@class='card-body']/h5"));
		//System.out.println(productsName);
		
		  for(int i=0;i<productsName.size();i++) {
		  
		  
		  String oneItem=productsName.get(i).getText(); 
		  List<String> itemsList=Arrays.asList(expectedItems); 
		  if(itemsList.contains(oneItem))
		  {
		  driver.findElements(By.cssSelector("button[class*='btn w-10']")).get(i).click();
		  Thread.sleep(3000);
		  
		  } }
		 
		/*for(int i=0;i<productsName.size();i++)
		{
			
		
		String oneItem=productsName.get(i).getText();
		if(oneItem.equalsIgnoreCase("ADIDAS ORIGINAL"))
		{
			driver.findElements(By.cssSelector("button[class*='btn w-10']")).get(i).click();
		}
		
		}
		driver.quit();*/
		driver.quit();
}
}
