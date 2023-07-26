package nagp.selenium.pageactions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import nagp.selenium.pageobjects.HomePageObjects;
import nagp.selenium.utils.BaseTest;
import nagp.selenium.utils.ExcelUtils;
import nagp.selenium.utils.PropertyReader;
import nagp.selenium.utils.SeleniumUtils;

public class HomePageAction {
	WebDriver driver;
	HomePageObjects homePageObjects;
	private static final Logger LOGGER = LogManager.getLogger(HomePageAction.class);

	public HomePageAction(WebDriver driver) {
		this.driver = driver;
		homePageObjects = PageFactory.initElements(driver, HomePageObjects.class);
	}

	/**
	 * This method is to check whether logo on home page is visible
	 * 
	 * @return true if logo on hoe page is visible
	 */
	public boolean checkLogoHomePage() {
		LOGGER.info("Checking presence of logo on Home page");
		return SeleniumUtils.isElementPresent(driver, homePageObjects.logo);
	}

	/**
	 * This method is to sign out
	 */
	public void logout() {
		SeleniumUtils.click(driver, homePageObjects.loggedInUserLink);
		SeleniumUtils.click(driver, homePageObjects.signOutButton);
		LOGGER.info("User has been logged out");
	}

	/**
	 * This method is to subscribe to newsletter
	 * 
	 * @param emailId
	 */
	public void subscribeNewsletter(String emailId) {
		SeleniumUtils.scrollToWebElement(driver, homePageObjects.subscriptionEmailBox);
		LOGGER.info("User has been scrolled down to the newsletter subscribtion box");
		SeleniumUtils.setValue(driver, homePageObjects.subscriptionEmailBox, emailId + Math.random() + "@gmail.com");
		SeleniumUtils.click(driver, homePageObjects.subscribeButton);
	}

	/**
	 * @return true if newsletter subscribe success message comes
	 */
	public boolean checkSubscribeSuccessMessageComes() {
		LOGGER.info("Checking presence of Subscribe newsletter success message");
		return SeleniumUtils.isElementPresent(driver, homePageObjects.subscriptionSucessMessage);
	}

	/**
	 * This method is to fetch and compare menu items and in excel and on home page
	 * 
	 * @return true if menu items in excel and on home pages same
	 * @throws IOException
	 */
	public boolean getMenuItems(String fileName) throws IOException {
		List<String> menuItems = SeleniumUtils.getDataFromList(driver, homePageObjects.menuItems);
		List<String> menuItemsExcel = ExcelUtils.getDataOfExcelColumn(
				System.getProperty("user.dir") + "//" + PropertyReader.getValue("TestDataPath") + "//" + fileName, 0,
				0);
		return menuItems.equals(menuItemsExcel);
	}

	/**
	 * This method is to launch mens jacket page
	 */
	public void launchJacketsPage() {
		try {
			SeleniumUtils.pause(5000);
			SeleniumUtils.mouseHoverElement(driver, homePageObjects.menMenuItem);
			SeleniumUtils.pause(2000);
			SeleniumUtils.mouseHoverElement(driver, homePageObjects.TopsMenuItem);
			SeleniumUtils.click(driver, homePageObjects.jacketsMenuItem);
			LOGGER.info("User has landed on Jackets listing page");
		} catch (Exception e) {
			LOGGER.error("Some error has encountered whiel navigating on jacket apparel ", e);
			fail();
		}
	}

	/**
	 * This method is to search and get size of auto suggestion in search bar
	 * 
	 * @param searchkey
	 * @return size of auto suggestion count in search bar
	 */
	public int searchApparelSearchBar(String searchkey) {
		try {
			LOGGER.info("User is searching apparel : " + searchkey);
			SeleniumUtils.setValue(driver, homePageObjects.searchBar, searchkey);
			SeleniumUtils.pause(3000);
			SeleniumUtils.setValue(driver, homePageObjects.searchBar, " ");
			return SeleniumUtils.waitForVisibilityOfElements(driver, homePageObjects.searchAutoSuggestion).size();
		} catch (Exception e) {
			LOGGER.error("Some error has encounetred while searching on search bar", e);
			fail();
		}
		return 0;
	}

	/**
	 * This method is to land on search result page and check landing search results
	 * label is coming
	 * 
	 * @return true if on landing search results label is coming
	 */
	public boolean landOnSearchResultPage() {
		try {
			SeleniumUtils.click(driver,
					SeleniumUtils.waitForVisibilityOfElements(driver, homePageObjects.searchAutoSuggestion).get(0));
			LOGGER.info("User has landed on search result page");
			return SeleniumUtils.isElementPresent(driver, homePageObjects.searchResultPageLabel);
		} catch (Exception e) {
			LOGGER.error("Some error has encounetred while navigating on search result page");
			fail();
		}
		return false;
	}

	/**
	 * This method is to check sign out success message comes
	 * 
	 * @return true if sign out success message comes
	 */
	public boolean checkSignOutSuccessMessage() {
		LOGGER.info("Checking presence of sign out success message");
		return SeleniumUtils.isElementPresent(driver, homePageObjects.signOutSuccessMessage);
	}
}