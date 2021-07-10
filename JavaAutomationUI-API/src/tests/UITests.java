package tests;

import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import utills.Base;
import utills.PrepareUITests;


public class UITests extends PrepareUITests {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@Test(enabled = true, priority = 1) // Test 1 - Check if header menu links displayed.
	void headerMenuCheck() {
		Base.methodeName("headerMenuCheck");
		assertTrue(hp.headerMenuCheck(),"the Header is not valid");
	}

	@Test(enabled = true, priority = 2) // Test 2 - Check if there is 21 links while hover on "Premier League".
	void is21Links() {
		Base.methodeName("is21Links");
		assertTrue(hp.is21Links(),"there is no 21 links.");
	}

	@Test(enabled = true, priority = 3) // Test 3 - Change Language to Spanish and verify it. 
	void isSpanish() {
		Base.methodeName("isSpanish");
		assertTrue(hp.isSpanish(),"the site is not spanish like expected.");
	}

	@Test(enabled = true, priority = 4) // Test 4 - Validate each link has a suitable icon
	void isSuitableLinksToIcons() {
		Base.methodeName("isSuitableLinksToIcons");
		assertTrue(hp.isSuitableLinksToIcons(),"Links is not suite to icons");
	}

	@Test(enabled = true, priority = 5) // Test 5 - Verify "Premier League" Becomes Red while hover.
	void isPremierBecomesRed() {
		Base.methodeName("isPremierBecomesRed");
		assertTrue(hp.isPremierBecomesRed(),"premier title is not becomes red.");
	}

	@Test(enabled = true, priority = 6) // Test 6 - Navigate to "Arsenal" page.
	void isNavigateToArsenal() {
		Base.methodeName("isNavigateToArsenal");
		assertTrue(arsenal.isNavigateToArsenal(),"navigate to Arsenal Page failed.");
	}
	@Test(enabled = true, priority = 7) // Test 7 - Navigate to "Arsenal" page and validate all the posts below "More Arsenal News" have a valid cover image.
	void eachPostsHaveCover() {
		Base.methodeName("eachPostsHaveCover");
		assertTrue(arsenal.eachPostsHaveCover(),"validate all the posts have a valid cover image failed");
	}

	@Test(enabled = true, priority = 8) // Test 8 - Navigate to "Contact Us" page.
	void isNavigateToContactUs() {
		Base.methodeName("isNavigateToContactUs");
		assertTrue(contactUs.isNavigateToContactUs(),"navigate to Contact Us page failed.");
	}

	@Test(enabled = true, priority = 9) // Test 9 - Navigate to "Contact Us" page and insert data.
	void contactUsInsertDetails() {
		Base.methodeName("contactUsInsertDetails");
		assertTrue(contactUs.insertDetails("Tal", "Elbit", "tal2@gmail.com", "0525555555", "Career", 
				"lital@gmail.com", "Test of insert details"), "insert details failed.");
	}
} 
