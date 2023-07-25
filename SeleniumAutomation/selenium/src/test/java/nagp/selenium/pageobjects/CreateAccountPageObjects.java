package nagp.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageObjects {
	@FindBy(xpath = "(//a[text()='Create an Account'])[1]")
	public WebElement createAccountLink;
	@FindBy(xpath = "//input[@id='firstname']")
	public WebElement firstName;
	@FindBy(xpath = "//input[@id='lastname']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@autocomplete='email']")
	public WebElement emailId;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@name='password_confirmation']")
	public WebElement confirmPassword;
	@FindBy(xpath = "(//span[text()='Create an Account'])[1]")
	public WebElement createAccountButton;
	@FindBy(xpath = "//*[contains(text(),'Thank you for registering with Main Website Store')]")
	public WebElement createNewAccountConfirmationMessage;
	@FindBy(xpath = "//*[contains(text(),'There is already an account')]")
	public WebElement alreadyAccountExistsMessage;;

}
