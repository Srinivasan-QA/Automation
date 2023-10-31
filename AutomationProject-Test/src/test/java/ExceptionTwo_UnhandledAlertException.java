package com.exceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


// Code to trigger UnhandleAlertException

public class ExceptionTwo_UnhandledAlertException {

	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		WebElement btn = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		btn.click();
		
		
		driver.close();
		
		
		
	}
}
