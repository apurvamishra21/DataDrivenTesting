package elementRepository;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.genericLib.DataUtility.DataUtility;

public class BaseClass {
	
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	public static WebDriver monitorDriver;
	
	@BeforeClass
   public void launchBrowser() throws IOException{
		
	System.out.println("Browser Launch");
	System.setProperty("webdriver.chrome.driver","E:\\JAVASDET\\SELENIUM\\browsers\\chromedriver.exe");
	 driver=new ChromeDriver();
	 monitorDriver=driver;
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

}
