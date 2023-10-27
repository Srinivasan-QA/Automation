package testCommon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import common.SeleniumBaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest extends SeleniumBaseClass{
	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		Properties properties = new Properties();
		properties.load(new FileInputStream("./LoginTestData.properties")); // Sharing the path where file was kept
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(properties.getProperty("Url"));
		driver.findElement(By.id("username")).sendKeys(properties.getProperty("Username"));
		driver.findElement(By.id("password")).sendKeys(properties.getProperty("Password"));
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
}

