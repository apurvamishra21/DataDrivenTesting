package com.vtiger.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import multipleBrowserExecutions.BaseClass;

public class CreateNewProduct extends BaseClass {
	@Test
	public void newProductCreation() throws IOException{
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		System.out.println(du.getDataFromExcel("Sheet1", 1, 1));
		driver.findElement(By.name("productname")).sendKeys(du.getDataFromExcel("Sheet1", 1, 1),Keys.ENTER);
		System.out.println("Product created successfully");
		
	}

}
