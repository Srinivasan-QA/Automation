package testCommon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.LoginDataUtils;

public class UtilsDataProvider extends LoginDataUtils{

	/*@Test(dataProvider = "login") // passing the data provider using the name of data provider
	public void LoginMultipleCredValidationFun(String username, String password) throws InterruptedException {
		
	// To test with multiple input credentials using data from a data provider method
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	
	
	Thread.sleep(2000);
	driver.quit();
	}*/
	
	@Test(dataProvider = "login", dataProviderClass = UtilsDataProvider.class) // passing the data provider using the name of data provider and no need of inheritance 
	// Instead of giving name we can give method name also in data provider
	public void LoginMultipleCredValidationFunInheritance(String username, String password) throws InterruptedException {
		
	// To test with multiple input credentials using data from a data provider method
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	
	
	Thread.sleep(2000);
	driver.quit();
	}
	
	
	
}
