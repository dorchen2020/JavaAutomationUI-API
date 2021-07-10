package pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.UIActions;

public class Arsenal {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	private WebDriverWait wait;
	private HomePage hp;

	@FindBy(xpath = "//a[.//*[text()='Arsenal']]")
	WebElement arsenalLink;
	
	@FindBy(xpath = "//img[@class='_1olj64kn']")
	WebElement postsCoversList;
	
	public Arsenal(WebDriver driver) {
		wait = new WebDriverWait(driver, 15);
		hp = new HomePage(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isNavigateToArsenal() {
		log.info("Navigate to Arsenal");
		hp.premierHover();
		UIActions.slowlyClick(arsenalLink);
		return UIActions.isUrlContains("teams/arsenal");
	}

	public boolean eachPostsHaveCover() {
		isNavigateToArsenal();
		log.info("assert all posts below \"More Arsenal News\" have a valid cover image.");
		
		// post images elements will load just with slowly scroll
		UIActions.scrollSlowly(100,20); 
		
		List<WebElement> postImages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath(UIActions.webEleToLocator(postsCoversList))));
		return postImages.size()==12;
	}
}