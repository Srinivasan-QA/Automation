package testCommon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDataProvider {
	
	@DataProvider(name = "login") // Defining name for the data provider
	public String[][] getData() {
		String[][] data = new String[2][2];
		
		data[0][0] = "student";
		data[0][1] = "Password123";
		
		data[1][0] = "student1";
		data[1][1] = "Password12";
		
		return data;
	}
	
	
	@Test(dataProvider = "login") // passing the data provider using the name of data provider
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
	}
}
