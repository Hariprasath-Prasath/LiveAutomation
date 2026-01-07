package tutorials.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountNewsLetterPage;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Utilitis;

public class Register extends Base {

	WebDriver driver;
	Properties prop;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	AccountNewsLetterPage accountNewsLetterPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setup() {

		driver = openBrowserApplication();
		prop = Utilitis.loadProperties();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterMailId(Utilitis.getNewMailID());
		registerPage.enterTelePhoneNo(prop.getProperty("telephoneNo"));
		registerPage.enterPassWord(prop.getProperty("passWord"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPass"));

		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickContinueBtn();

		Assert.assertTrue(accountSuccessPage.isUserLogedIn());

		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);
		String expectedproperDetails1 = "Congratulations! Your new account has been successfully created!";
		String expectedproperDetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedproperDetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedproperDetails4 = "contact us";

		String actualProperDetails = accountSuccessPage.getPageContent();

		Assert.assertTrue(actualProperDetails.contains(expectedproperDetails1));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetails2));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetails3));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetails4));

		accountPage = accountSuccessPage.clickOnContinueBtn();

		Assert.assertTrue(accountPage.isAccountPageDisplayed());

	}

	@Test(priority = 2)
	public void verifyRegisterAccountWithAllFields() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterMailId(Utilitis.getNewMailID());
		registerPage.enterTelePhoneNo(prop.getProperty("telephoneNo"));
		registerPage.enterPassWord(prop.getProperty("passWord"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPass"));
		registerPage.clickNewsLetter();
		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickContinueBtn();

		Assert.assertTrue(accountSuccessPage.isUserLogedIn());
		Assert.assertTrue(accountSuccessPage.accountSucessIsDisplyed());

		String expectedProperDetails1 = "Your Account Has Been Created!";
		String expectedProperDetails2 = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetails3 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetails4 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetails5 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expectedProperDetails6 = "contact us";

		String actualProperDetails = accountSuccessPage.getPageContent();

		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails1));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails2));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails3));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails4));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails5));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails6));

		accountPage = accountSuccessPage.clickOnContinueBtn();
		Assert.assertTrue(accountPage.isAccountPageDisplayed());

	}

	@Test(priority = 3)
	public void verifyRegistringAccountWithoutFillField() {

		registerPage.clickContinueBtn();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneNumber = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivatePolicyWarring = "Warning: You must agree to the Privacy Policy!";
		String expectedWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerPage.getFistNameWarning(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.lastNameWarning(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarning(), expectedEmailWarning);
		Assert.assertEquals(registerPage.getTelephoneWarning(), expectedTelephoneNumber);
		Assert.assertEquals(registerPage.getPasswordWarning(), expectedPasswordWarning);
		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedWarning);

	}

	@Test(priority = 4)
	public void verifingRigisteringAccoundNewsletterfield() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("firstName"));
		registerPage.enterMailId(Utilitis.getNewMailID());
		registerPage.enterTelePhoneNo(prop.getProperty("telephoneNo"));
		registerPage.enterPassWord(prop.getProperty("passWord"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPass"));

		registerPage.clickNewsLetter();
		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickContinueBtn();

		accountSuccessPage.isUserLogedIn();
		accountSuccessPage.accountSucessIsDisplyed();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed());

		String actualText = accountSuccessPage.getPageContent();

		String expectedtext1 = "Your Account Has Been Created!";
		String expectedtext2 = "Congratulations! Your new account has been successfully created!";
		String expectedtext3 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedtext4 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedtext5 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expectedtext6 = "contact us";

		Assert.assertTrue(actualText.contains(expectedtext1));
		Assert.assertTrue(actualText.contains(expectedtext2));
		Assert.assertTrue(actualText.contains(expectedtext3));
		Assert.assertTrue(actualText.contains(expectedtext4));
		Assert.assertTrue(actualText.contains(expectedtext5));
		Assert.assertTrue(actualText.contains(expectedtext6));

		accountPage = accountSuccessPage.clickOnContinueBtn();
		accountNewsLetterPage = accountPage.subAndUnSub();

		Assert.assertTrue(accountNewsLetterPage.isDisplayNewsLetterBread());
		Assert.assertTrue(accountNewsLetterPage.isSelectedyesNewsLetterBtn());

	}

	@Test(priority = 5)
	public void verifyRegisterAccoutWithNoOption() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterMailId(Utilitis.getNewMailID());
		registerPage.enterTelePhoneNo(prop.getProperty("telephoneNo"));
		registerPage.enterPassWord(prop.getProperty("passWord"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPass"));

		registerPage.clickNewsLetter();
		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickContinueBtn();

		Assert.assertTrue(accountSuccessPage.isUserLogedIn());
		Assert.assertTrue(accountSuccessPage.accountSucessIsDisplyed());

		String actualText = accountSuccessPage.getPageContent();

		String expectedtext1 = "Your Account Has Been Created!";
		String expectedtext2 = "Congratulations! Your new account has been successfully created!";
		String expectedtext3 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedtext4 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedtext5 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expectedtext6 = "contact us";

		Assert.assertTrue(actualText.contains(expectedtext1));
		Assert.assertTrue(actualText.contains(expectedtext2));
		Assert.assertTrue(actualText.contains(expectedtext3));
		Assert.assertTrue(actualText.contains(expectedtext4));
		Assert.assertTrue(actualText.contains(expectedtext5));
		Assert.assertTrue(actualText.contains(expectedtext6));

		accountPage = accountSuccessPage.clickOnContinueBtn();

		Assert.assertTrue(accountPage.isAccountPageDisplayed());

		accountNewsLetterPage = accountPage.subAndUnSub();

		Assert.assertTrue(accountNewsLetterPage.isNoNewButtonselected());

	}
	
	@Test(priority = 6)
	public void verifingRegisterAccountUsingMultileWays(){
		
		
		Assert.assertTrue(registerPage.isDisRegisterBread());
		
		registerPage.clickMyAccountMeno();
		loginPage = registerPage.selectLogInOption();
		loginPage.clickContinueButton();
		
		Assert.assertTrue(registerPage.isDisRegisterBread());
		
		registerPage.clickMyAccountMeno();
		loginPage = registerPage.selectLogInOption();
		
		loginPage.clickRegisterOption();
		
		Assert.assertTrue(registerPage.isDisRegisterBread());
		
	}

}
