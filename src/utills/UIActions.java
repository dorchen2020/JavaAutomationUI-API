package utills;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIActions extends PrepareUITests {
	
	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	private static JavascriptExecutor jse;

	
	// scroll to the bottom or top of the page
	public static void scroll(String bottomOrTop) {
		jse = (JavascriptExecutor)driver;
		switch (bottomOrTop) {
		case "bottom": jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");	break;
		case "top":	   jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");	break;
		default:	   log.error("Scroll function can get only \"bottom\" or \"top\" arguments");			break;
		}
	}
	
	// scroll slowly to the bottom
	public static void scrollSlowly(int count, int downPx) {
		jse = (JavascriptExecutor)driver;
		for (int i = 0; i <= count; i++) {
			jse.executeScript("window.scrollBy(0,"+downPx+")", "");
		}
	}
	
	// wait and return partial URL
	public static boolean isUrlContains(String partialUrl) {
		try {
			wait = new WebDriverWait(driver, 8);
			return wait.until(ExpectedConditions.urlContains(partialUrl));
		}
		catch (Exception e) {
			log.error("Check URL failed.");
			return false;
		}
	}

	// wait until clickable and click on element
	public static boolean slowlyClick(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
			return true;			
		}
		catch (Exception e) {
			log.error("Click on element failed.");
			e.printStackTrace();
			return false;
		}
	}

	// get xpath/id/link/css locator from WebElement
	public static String webEleToLocator(WebElement e) {
		String str = e.toString(); 
		String[] listString= {}; 
		if(str.contains("xpath")) 
			listString = str.split("xpath:"); 
		else if(str.contains("id")) 
			listString = str.split("id:");
		else if(str.contains("link text")) 
			listString = str.split("link text:");

		// css locator pattern can contains 'By.cssSelector: ...' OR 'css selector: ...'
		else if(str.contains("css selector") || str.contains("cssSelector")) 
			listString = str.split("elector:"); 
		String last = listString[1].trim(); 
		return last.substring(0, last.length()-1); 
	}
}
