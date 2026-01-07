package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailId;
	
	@FindBy(id = "input-telephone")
	private WebElement telePhoneNo;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetter;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement fNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Warning')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Register']")
	private WebElement registerBread;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMeno;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enterMailId(String mailId) {
		emailId.sendKeys(mailId);
	}
	
	public void enterTelePhoneNo(String phoneNo) {
		telePhoneNo.sendKeys(phoneNo);
	}
	
	public void enterPassWord(String pWord) {
		password.sendKeys(pWord);
	}
	
	public void enterConfirmPassword(String cWrod) {
		confirmPassword.sendKeys(cWrod);
	}
	
	public void selectPrivacyPolicy() {
		privacyPolicy.click();
	}
	
	public void clickNewsLetter() {
		yesNewsLetter.click();
	}
		
	public AccountSuccessPage clickContinueBtn() {
		continueBtn.click();
		return new AccountSuccessPage(driver);
	}

	public String getFistNameWarning() {
		return fNameWarning.getText();
	}
	
	public String lastNameWarning() {
		return lNameWarning.getText();
	}
	
	public String getEmailWarning() {
		return emailWarning.getText();
	}
	
	public String getTelephoneWarning() {
		return telephoneWarning.getText();
	}
	
	public String getPasswordWarning() {
		return passwordWarning.getText();
	}
	
	public String getPrivacyPolicyWarning() {
		return privacyPolicyWarning.getText();
	}
	
	public boolean isDisRegisterBread() {
		return registerBread.isDisplayed();
	}
	
	public void clickMyAccountMeno() {
		myAccountDropMeno.click();
	}
	
	public LoginPage selectLogInOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
}
