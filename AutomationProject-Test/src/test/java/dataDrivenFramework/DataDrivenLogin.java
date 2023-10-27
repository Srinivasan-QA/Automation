package dataDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenLogin {
	
	
	String[][] data = {
			{"Admin","admin123"},
			{"Admin","admin13"},
			{"Admina","admin123"},
			{"Adm","admin3"}
	};
	
	@DataProvider(name="LoginData")
	public String[][] loginDataProvider(){
		return data;
	}
	
	@Test(dataProvider="LoginData")
	public void Login(String uname, String pwd) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement UserName = driver.findElement(By.xpath("//input[@placeholder='Username']")); //
		UserName.sendKeys(uname);
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(pwd);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		
		Thread.sleep(2000);
		driver.quit();
;	}
	
	
	
	
}

