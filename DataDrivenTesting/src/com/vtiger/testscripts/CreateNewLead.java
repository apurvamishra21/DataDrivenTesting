package com.vtiger.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import multipleBrowserExecutions.BaseClass;

public class CreateNewLead extends BaseClass{
	
	@Test(groups= {"smoke","System"})
	public void newLeadCreation() throws IOException{
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
		System.out.println(du.getDataFromExcel("Sheet3", 1, 1));
		driver.findElement(By.name("lastname")).sendKeys(du.getDataFromExcel("Sheet3", 1, 2),Keys.ENTER);
		driver.findElement(By.name("company")).sendKeys(du.getDataFromExcel("Sheet3", 1, 3),Keys.ENTER);
		System.out.println("lead created successfully");
		
	}

}


