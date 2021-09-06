package multipleBrowserExecutions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.genericLib.DataUtility.DataUtility;

public class CrossBrowserExecutionBaseClass {
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	
	@Parameters("browser")
	@BeforeClass
   public void launchBrowser(String browser) throws IOException{
		
	if(browser.equals("chrome")) {	
	System.out.println(" Chrome Browser Launch");
	System.setProperty("webdriver.chrome.driver","E:\\JAVASDET\\SELENIUM\\browsers\\chromedriver.exe");
	 driver=new ChromeDriver();
	}else if(browser.equals("firefox")) {
		System.out.println(" firefox Browser Launch");
		System.setProperty("webdriver.gecko.driver","E:\\JAVASDET\\SELENIUM\\browsers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}else if(browser.equals("Opera")) {
		System.out.println(" Opera Browser Launch");
		System.setProperty("webdriver.opera.driver","E:\\JAVASDET\\SELENIUM\\browsers\\operadriver.exe");
		driver=new OperaDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	


}
