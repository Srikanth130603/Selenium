package genericUtilities;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	Select select;
	/**
	 * This method launches the user desired browser
	 * @param browser
	 * @return webDriver
	 */
	public WebDriver launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
			driver =new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else
			System.out.println("Invalid browser");
		return driver;
		
	}
	/**
	 * This method maximizes the browser window
	 * 
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method navigates to an application
	 * @param url
	 */
	public void navigateToapp(String url)
	{
		driver.get(url);
	}
	/**
	 * This method waits till element or elements are found
	 */
	public void waitTillElementFound(long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	/**
	 * This method Waits till element or elements are displayed
	 * param element
	 * param time
	 * @return WebElement
	 */
	public WebElement explicitwait(long time,WebElement element)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 *This method Waits till element or elements are displayed
	 * param element
	 * @param time
	 * @param element 
	 * @return Webelement
	 */
	public WebElement explicitwait(WebElement element,long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 *This method Waits till element or elements are displayed
	 * param element
	 * @param time
	 * @param title 
	 * @return Boolean
	 */
	public Boolean explicitwait(long time, String title)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * Chapter 2
	 * Actions class related
	 * This  method is used to perform mouse hover on an element
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		actions= new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform double click on an element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element)
	{
		actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on an element
	 * @paramelement
	 * @param element
	 */
	public void dragAndDropAnElement(WebElement element,WebElement dest)
	{
		actions =new Actions(driver);
		actions.dragAndDrop(element, dest).perform();
	}
	/**
	 * This method selects an option from dropdown based on index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method select an option from dropdown based on value attibute
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, String value)
	{
		select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * this method selects an option from drop down based on visible text
	 * @param text
	 * @param element
	 * @param text 
	 */
	public void handleDropDown(String text,WebElement element)
	{
		select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method deselect an option from down based on index
	 * @param element
	 * @param index
	 */
	public void deselect(WebElement element, int index)
	{
		select=new Select(element);
		select.deselectByIndex(index);
	}
	/**
	 * this method deselect an option from down based on value
	 * @param element
	 * @param index
	 * @param value 
	 */
	public void deselect(WebElement element,String value)
	{
		select=new Select(element);
		select.deselectByValue(value);
	}
	/**
	 * THis method is used to switch to frame based on frame Index
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * THis method is used to switch to frame based on id or name Attribute
	 * @param index
	 */
	public void switchToFrame(String idOrNameAttribute)
	{
		driver.switchTo().frame(idOrNameAttribute);
	}
	/**
	 * This method is used to switch to frame based on frame element
	 * @param frame Element
	 */
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to Switch to back from frame
	 */
	public void switchBackFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method captures the screenshot of a web page
	 * @param  driver
	 * @return String
	 */
	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * This method captures the screenshot of a web page
	 * @param  driver
	 * @return String
	 */
	public String getScreenshot(WebDriver driver,String classname,JavaUtility jutil)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp= ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+classname+"_"+ jutil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(temp, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}

	/**
	 * This method scrolls till the element based on element reference
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method scrolls till the element based on element location
	 * 
	 * @param location
	 */
	public void scrollToElement(Point location) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + location.getX() + "," 
														+ location.getY() + ")");
	}

	/**
	 * This method handles alert pop up
	 * 
	 * @param status
	 */
	public void handleAlert(String status) {
		if (status.equalsIgnoreCase("ok"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method returns current window reference
	 * @return String
	 */
	public String getParentWindowID() {
		return driver.getWindowHandle();
	}
	
	/**
	 * This method switches to expected window or tab based on window title
	 * @param expectedTitle
	 */
	public void switchToWindow(String expectedUrl) {
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			if(driver.getCurrentUrl().contains(expectedUrl)) 
				break;
		}
	}
	
	/**
	 * This method closes the current window
	 */
	public void closeWindow() {
		driver.close();
	}
	
	/**
	 * This method closes all the windows 
	 */
	public void quitAllWindows() {
		driver.quit();
	}
	/**
	 * This method converts dynamic xpath to web element
	 * @param dynamicPath
	 * @param replaceData
	 * @return WebElement
	 */
	public WebElement convertDynamicXpathToWebElement(String dynamicPath, String replaceData) {
		return driver.findElement(By.xpath(String.format(dynamicPath, replaceData)));

	}
}
	
