package common;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumBaseClass implements SeleniumBaseAPI{
	long timeOuts = 10;
	long maxWaitTime = 10;
	
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public void setUp(String url) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Downloads\\ECLIPSE 2023\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		driver.get(url);
		wait = new WebDriverWait(driver, maxWaitTime);
	}

	public void setUpBrowser(Browser browserName, String url) {

		switch(browserName) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver","D:\\Downloads\\ECLIPSE 2023\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
				break;
		default:
			System.err.println("Browser Not defined");
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		driver.get(url);
		wait = new WebDriverWait(driver, maxWaitTime);
}
	
	//To close the browser
	public void close() {
		driver.close();
	}
	
	// To quit the browser
	public void quit() {
		driver.quit();
	}
	

	// To find element using locator and its value
	public WebElement element(Locators str, String value) {
		
		switch(str) {
		case ID:
			return driver.findElement(By.id(value));
		case NAME:
			return driver.findElement(By.name(value));
		case XPATH:
			return driver.findElement(By.xpath(value));
		case LINKTEXT:
			return driver.findElement(By.linkText(value));
		case CSSSELECTOR:
			return driver.findElement(By.cssSelector(value));
		case CLASSNAME:
			return driver.findElement(By.className(value));
		case TAGNAME:
			return driver.findElement(By.tagName(value));
		case PARTIALLINKTEXT:
			return driver.findElement(By.partialLinkText(value));
		}
		
		return null;
	}

	// To type user input
	public void type(WebElement ele, String testData) {
		// TODO Auto-generated method stub
		
		WebElement element = isElementVisible(ele);
		element.clear();
		element.sendKeys(testData);
	}
	
	//To type user input and perform action
	public void type(WebElement ele, String testData, Keys keys) {
		WebElement element = isElementVisible(ele);
		element.clear();
		element.sendKeys(testData,keys);
	}

	
	//Windows handling feature
	public void switchToWindow(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(i));
	}
	
	//Element visible
	public WebElement isElementVisible(WebElement ele) {
		WebElement element = wait.withMessage("Element is not visible").until(ExpectedConditions.visibilityOf(ele));
		return element;
	}
	
	//To append text with existing text content
	public void appendText(WebElement ele, String testdata) {
		WebElement element = isElementVisible(ele);
		element.sendKeys(testdata);
	}
	
	//Drop-down selection through value
	public void selectThroughValue(WebElement ele, String value) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByValue(value);
	}
	
	//Drop-down selection through Text
	public void selectThroughText(WebElement ele, String value) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByVisibleText(value);
	}
	
	//Drop-down selection through Index
	public void selectThroughIndex(WebElement ele, int position) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByIndex(position);
	}
	
	//Method to perform click action
	public void click(WebElement ele) {
		WebElement element = wait.withMessage("Element is not clickable").until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}

	
}
