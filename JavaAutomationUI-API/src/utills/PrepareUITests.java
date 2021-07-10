package utills;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Arsenal;
import pages.ContactUs;
import pages.HomePage;

public class PrepareUITests extends Base{

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	protected static WebDriver driver;
	protected static String browser = "";
	protected static WebDriverWait wait; 
	protected HomePage hp;
	protected Arsenal arsenal;
	protected ContactUs contactUs;
	
	@BeforeClass
	public void beforeAllUITests() throws IOException {
		Base.LoadLogsPropertiesFromFile();
		browser=ReadPropertyFile.getProp("browser");
		setupBrowser(browser);
	}

	@BeforeMethod
	public void beforeEachUITest() throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			throw new RuntimeException("Invalid Browser Type");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		driver.get("https://www.90min.com/");
		log.info("************************* Test Starts *************************");
		
		hp = new HomePage(driver);
		arsenal = new Arsenal(driver);
		contactUs = new ContactUs(driver);
	}

	@AfterMethod
	public void AfterEachTest() {
		driver.close();
		log.info("************************** Test Ends **************************\n");
	}

	@AfterClass
	public void AfterAllTests() {
		driver.quit();
	}

	// setup driver depending on the browser type.
	public static void setupBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":	WebDriverManager.chromedriver().setup();  break;
		case "edge":	WebDriverManager.edgedriver().setup();	  break;
		case "firefox":	WebDriverManager.firefoxdriver().setup(); break;
		default: throw new RuntimeException("Invalid Browser Type");		
		}
	}

}