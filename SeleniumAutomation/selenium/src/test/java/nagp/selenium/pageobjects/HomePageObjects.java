package nagp.selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	@FindBy(xpath = "//a[@class='logo']")
	public WebElement logo;
	@FindBy(xpath = "(//button[@data-action='customer-menu-toggle'])[1]")
	public WebElement loggedInUserLink;
	@FindBy(xpath = "(//a[contains(text(),'Sign Out')])[1]")
	public WebElement signOutButton;
	@FindBy(id = "newsletter")
	public WebElement subscriptionEmailBox;
	@FindBy(xpath = "//span[text()='Subscribe']")
	public WebElement subscribeButton;
	@FindBy(xpath = "//div[text()='Thank you for your subscription.']")
	public WebElement subscriptionSucessMessage;
	@FindBy(xpath = "//a[contains(@class,'level-top ui-corner-all')]")
	public List<WebElement> menuItems;
	@FindBy(xpath = "//span[text()='Men']/..")
	public WebElement menMenuItem;
	@FindBy(xpath = "(//span[text()='Tops']/..)[2]")
	public WebElement TopsMenuItem;
	@FindBy(xpath = "(//span[text()='Jackets'])[2]")
	public WebElement jacketsMenuItem;
	@FindBy(xpath = "//div[contains(@id,'option-label-size') and @aria-label='L']")
	public List<WebElement> apparelWithLSize;
	@FindBy(xpath = "//div[contains(@id,'option-label-color') and @aria-label='Blue']")
	public List<WebElement> apparelWithBlueColor;
	@FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
	public WebElement addTocartButton;
	@FindBy(xpath = "//a/span[text()='My Cart']")
	public WebElement myCart;
	@FindBy(xpath = "//button[text()='Proceed to Checkout']")
	public WebElement proceedToCheckoutButton;
	@FindBy(xpath = "//span[text()='Next']")
	public WebElement nextButton;
	@FindBy(xpath = "//button[text()='Place Order']")
	public WebElement placeOrderButton;
	@FindBy(xpath = "//span[text()='Thank you for your purchase!']")
	public WebElement thankYouForPurchaseMessage;
	@FindBy(id = "search")
	public WebElement searchBar;
	@FindBy(xpath = "//li[@role='option']")
	public List<WebElement> searchAutoSuggestion;
	@FindBy(xpath = "//span[contains(text(),'Search results for')]")
	public WebElement searchResultPageLabel;
	@FindBy(xpath = "//span[contains(text(),'You are signed out')]")
	public WebElement signOutSuccessMessage;

}
