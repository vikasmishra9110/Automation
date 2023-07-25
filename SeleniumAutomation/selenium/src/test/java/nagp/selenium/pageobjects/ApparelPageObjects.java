package nagp.selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparelPageObjects {

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
	@FindBy(xpath = "//span[text()='Thank you for your purchase!']")
	public WebElement thankYouForPurchaseMessage;

}
