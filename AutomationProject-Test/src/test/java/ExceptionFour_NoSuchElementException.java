package com.exceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//Code to trigger NoSuchElementException - when driver control is not switched to iFrame
public class ExceptionFour_NoSuchElementException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Frames.html");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello from iFrame");
		
		
		
	}

}
