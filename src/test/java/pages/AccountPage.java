package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInfoOption;
	
	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement sub_UnSub;
	
	public boolean isAccountPageDisplayed() {
		return editAccountInfoOption.isDisplayed();
	}
	
	public AccountNewsLetterPage subAndUnSub() {
		sub_UnSub.click();
		return new AccountNewsLetterPage(driver);
	}

}
