package multipleBrowserExecutions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.genericLib.DataUtility.DataUtility;

public class BaseClass {
	
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	
	@BeforeClass
   public void launchBrowser() throws IOException{
		
	System.out.println("Browser Launch");
	System.setProperty("webdriver.chrome.driver","E:\\JAVASDET\\SELENIUM\\browsers\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@BeforeMethod 
	public void login() throws IOException{
		
		System.out.println("Login to APP");
		driver.get(du.getDataFromProperty("Url"));
		driver.findElement(By.name("user_name")).sendKeys(du.getDataFromProperty("User_Name"));
		driver.findElement(By.name("user_password")).sendKeys(du.getDataFromProperty("Password"));
		driver.findElement(By.id("submitButton")).click();
		
	}
	@AfterMethod
	public void logout() {
		System.out.println("Logout from APP");
		 WebElement  signOutDD=driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		 Actions act=new Actions(driver);
		 act.moveToElement(signOutDD).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("Browser close");
		driver.quit();
	
	}
	
	
	 

}
