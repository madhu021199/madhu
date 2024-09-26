package democode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class example {
	
	@Test()
	public void login()
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.ultimatix.net/uxportal/uxportalhome.html/Megamenu");
		
	}

}
