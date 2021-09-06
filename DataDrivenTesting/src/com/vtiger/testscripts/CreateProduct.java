package com.vtiger.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.genericLib.DataUtility.DataUtility;

public class CreateProduct {
	
	public static void main(String [] args) throws IOException{
		
		DataUtility du=new DataUtility();
		
		System.setProperty("webdriver.chrome.driver","E:\\JAVASDET\\SELENIUM\\browsers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(du.getDataFromProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(du.getDataFromProperty("User_Name"));
		driver.findElement(By.name("user_password")).sendKeys(du.getDataFromProperty("Password"));
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		System.out.println(du.getDataFromExcel("Sheet1", 1, 1));
		driver.findElement(By.name("productname")).sendKeys(du.getDataFromExcel("Sheet1", 1, 1),Keys.ENTER);
		
		String product=driver.findElement(By.className("lvtHeaderText")).getText();
		System.out.println(product);
		if(product.contains("Product Information")){
			
			System.out.println("Product created successfully");
		}else {
				System.out.println("product not created successfully");
		}
	driver.close();
}
		
		
		
		
		
		
		
		
		
	}
	
	

