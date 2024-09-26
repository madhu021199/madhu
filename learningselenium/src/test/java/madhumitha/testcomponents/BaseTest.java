package madhumitha.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import madhumitha.pageobjectmodel.LandingPage;

public class BaseTest{

	public WebDriver driver;
	public LandingPage lp;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\madhumitha\\resources\\globaldata.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless"))
		{
			options.addArguments("headless");
		}
		driver=new ChromeDriver(options);
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	@BeforeMethod()
	public void launchApplication() throws IOException
	{
		initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();
		//return lp;
	}
	@AfterMethod()
	public void quit()
	{
		driver.close();
	}
	
	}

