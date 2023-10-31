package com.exceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//Code to trigger Stale elementException
public class ExceptionOne_StaleElementException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("Userone");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Userone");
		
		driver.navigate().refresh();
		
		// username.sendKeys("Userone");
		
		
		  try {
		  username.sendKeys("Userone");
		  }
		  
		  
		 catch(StaleElementReferenceException e)
			{
				username = driver.findElement(By.name("email"));
				username.sendKeys("Userone");
		
				password = driver.findElement(By.name("password"));
				password.sendKeys("Userone");
		
				Thread.sleep(2000);
		    }
		 
		driver.quit();

	}

}
