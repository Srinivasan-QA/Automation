package common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface SeleniumBaseAPI {
	

	/**
	 * This method represents the starting URL of the project and browser launches the URL
	 * @author ELCOT
	 * @param url
	 * @exception NullPointerException
	 */
	void setUp(String url);
	
	/**
	 * This method will launch the given browser with the given URL
	 * @param browserName
	 * @param url
	 */
	
	void setUpBrowser(Browser browserName, String url);
	
	/**
	 * This method will close the current browser window and WebDriver remains active
	 */
	
	void close();
	
	/**
	 * This method will close all the browser windows and ends the WebDriver
	 */
	
	void quit();
	
	/**
	 * This method will type user input
	 * @param ele
	 * @param testData
	 */
	void type(WebElement ele, String testData);
	

	/**
	 * This method will type user input and perform keyboard action
	 * @param ele
	 * @param testData
	 */
	
	void type(WebElement ele, String testData, Keys keys);
	
	
	/**
	 * This method will handle the windows
	 */
	void switchToWindow(int i);
	
	
	/**This method will wait for the element to be get visible in DOM
	 * 
	 * @param ele
	 * @return
	 */
	
	WebElement isElementVisible(WebElement ele);
	
	/**
	 * This method will append the user input with the existing data
	 * @param ele
	 * @param testdata
	 */
	
	void appendText(WebElement ele, String testdata);
	
	
	/**
	 * This method will handle the drop-down selection actions using value
	 * @param ele
	 * @param value
	 */
	void selectThroughValue(WebElement ele, String value);
	
	/**
	 * This method will handle the drop-down selection actions using text
	 * @param ele
	 * @param value
	 */
	void selectThroughText(WebElement ele, String value);
	
	/**
	 * This method will handle the drop-down selection actions using Index number
	 * @param ele
	 * @param value
	 */
	void selectThroughIndex(WebElement ele, int position);
	
	/**
	 * This method will handle the WebElement click actions
	 * @param ele
	 * @param value
	 */
	void click(WebElement ele);
}
