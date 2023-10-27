package testCommon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionValidation {
	@Test()
	public void Titel() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("Test Login | Practice Test Automation", driver.getTitle());
		Assert.assertNotEquals("Orange", driver.getTitle());
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
		Assert.assertTrue(UserName.isEnabled());
		
		// input[placeholder='Username']
		driver.quit();

}
}