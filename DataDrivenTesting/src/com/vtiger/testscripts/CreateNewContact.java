package com.vtiger.testscripts;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.DataUtility.BaseClass;
@Listeners(com.vtiger.genericLib.DataUtility.ListenerImplementation.class)
public class CreateNewContact extends BaseClass{
	
	@Test
	public void Contact() throws IOException{
		
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		System.out.println(du.getDataFromExcel("Sheet2", 1, 1));
		driver.findElement(By.name("lastname")).sendKeys(du.getDataFromExcel("Sheet2", 1, 1),Keys.ENTER);
		System.out.println("Contact created successfully");
	}
		
		/*@Test
		public void newContactCreation1() throws IOException{
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
			System.out.println(du.getDataFromExcel("Sheet2", 1, 1));
			driver.findElement(By.name("lastname")).sendKeys(du.getDataFromExcel("Sheet2", 1, 1),Keys.ENTER);
			System.out.println("Contact created successfully");
		
	}
		@Test
		public void newContactCreation2() throws IOException{
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
			System.out.println(du.getDataFromExcel("Sheet2", 1, 1));
			driver.findElement(By.name("lastname")).sendKeys(du.getDataFromExcel("Sheet2", 1, 1),Keys.ENTER);
			System.out.println("Contact created successfully");
		
	}*/


}



