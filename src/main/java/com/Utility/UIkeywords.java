package com.Utility;

import java.awt.Window;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains UI keywords which are applicable for WebElements and general actions
 * This is a singleton class .To create object of this class,use {@code getInstance()} method
 * @author Mayur Kulange
 *
 */
public class UIkeywords {
	public WebElement element;
	public static RemoteWebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(UIkeywords.class);
	/*private static UIkeywords uikeywords;
	static {
		uikeywords = new UIkeywords();
	}
	public static UIkeywords getInstance() {
		return uikeywords;
	}
	private UIkeywords() {
		
	}*/
/**
 *This method use to launch specified browser 
 *<ul>
 *<li>chrome</li>
 *<li>firefox</li>
 *<li>edge</li>
 * </ul>
 */
	public static void openBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			LOG.error("Invalid browser name " + BrowserName);
		}
	}
	
	public static void launchURL(String url) {
		driver.get(url);
	}
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element=null;
		if(locatorType.equalsIgnoreCase("xpath")) {
		element= driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("css")) {
			element= driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("id")) {
			element= driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("name")) {
			element= driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("LinkText")) {
			element= driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("partialLinkText")) {
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("classname")) {
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("tagName")) {
			element=driver.findElement(By.tagName(locatorValue));
		}
		else {
			System.out.println("Invalid locatorType");
		}
		return element;
		
	}

	@Deprecated
	public static void enterText(String textToEnter,String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	public static void enterText(String locator, String textToEnter) {
		String parts[]=locator.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
		
	}
	@Deprecated
	public static void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public static void click(String locator) {
		String parts[]=locator.split("##");
		getWebElement(parts[0],parts[1]).click();
	}

	public static String getTitleOfPage() {
		return driver.getTitle();
	}
	
	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	public static void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}
	public static void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	public static void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	public static void selectBy(String locatorType, String locatorValue,String selectorType,String value) {
		Select s= new Select(getWebElement(locatorType, locatorValue));
		if(selectorType.equalsIgnoreCase("ByIndex")) {
			
			s.selectByIndex(Integer.parseInt(value));;
		}
		else if(selectorType.equalsIgnoreCase("ByValue")) {
			s.selectByValue(value);
		}
		else if(selectorType.equalsIgnoreCase("ByVisibleText")) {
			s.selectByVisibleText(value);
		}
		
	}
	
	public static void scrollBy(int scrollValue) {
		driver.executeAsyncScript("window.scrollBy(0,"+scrollValue+")");
	}
}
