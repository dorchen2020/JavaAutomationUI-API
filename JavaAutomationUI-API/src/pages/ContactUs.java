package pages;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.UIActions;

public class ContactUs {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	private WebDriverWait wait;
	private HomePage hp;
	private Select select;

	@FindBy(id = "Full-Name")
	WebElement nameInput;

	@FindBy(id = "Company-Name")
	WebElement companyInput;

	@FindBy(id = "Business-Email")
	WebElement businessEmailInput;

	@FindBy(id = "Phone-number")
	WebElement phoneInput;
	
	@FindBy(id = "Inquiries")
	WebElement inquiryTypeSelect;

	@FindBy(id = "How-did-you-hear-about-us-2")
	WebElement hearFromUsInput;

	@FindBy(id = "Message")
	WebElement messageInput;

	@FindBy(id = "Submit_BT")
	WebElement submitBTN;

	@FindBy(xpath = "//*[@id='Contact-us-section']//div[contains(text(), 'Thank you!')]")
	WebElement confirmSubmitText;

	public ContactUs(WebDriver driver) {
		wait = new WebDriverWait(driver, 15);
		hp = new HomePage(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isNavigateToContactUs() {
		hp.contactUsLink();
		return UIActions.isUrlContains("minutemedia");
	}

	public boolean insertDetails(String name, String company, String email, String phone, String subject, String hearAboutUs, String message) {
		
		hp.contactUsLink();

		log.info("Insert data to submit");
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform(); 
//		CONTROL+END cannot use when there is a focus on input element, need to "stand" on the page.
		UIActions.scroll("bottom");
		nameInput.sendKeys(name);
		companyInput.sendKeys(company);
		businessEmailInput.sendKeys(email);

		phoneInput.sendKeys(phone);
		select = new Select(inquiryTypeSelect);
		select.selectByVisibleText(subject);
		hearFromUsInput.sendKeys(hearAboutUs);
		messageInput.sendKeys(message);
		UIActions.slowlyClick(submitBTN);
		
		// confirmation text of submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UIActions.webEleToLocator(confirmSubmitText)))).isDisplayed(); 
		return true;			
	}
}
