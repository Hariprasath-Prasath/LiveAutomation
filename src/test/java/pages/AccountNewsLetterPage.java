package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountNewsLetterPage {
	
	WebDriver driver;
	public AccountNewsLetterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Newsletter']")
	private WebElement newsLetterBread;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	private WebElement noNewsButton;
	
	public boolean isDisplayNewsLetterBread() {
		return newsLetterBread.isDisplayed();
	}
	
	public boolean isSelectedyesNewsLetterBtn() {
		return yesNewsButton.isSelected();
	}
	
	public boolean isNoNewButtonselected() {
		return noNewsButton.isSelected();
	}
}
