package tutorials.Register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_018 {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	@Test
	public void verifyRegisteringAccountFieldsHeightWidthAligment() throws InterruptedException, IOException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		String expectedHeight = "34px"; 
		String expectedWidth = "701.25px";

		WebElement firstName = driver.findElement(By.id("input-firstname"));
		String firstNameHeight = firstName.getCssValue("height");
		String firstNameWidth = firstName.getCssValue("width");
		Assert.assertEquals(firstNameHeight, expectedHeight);
		Assert.assertEquals(firstNameWidth, expectedWidth);
		
		wait.until(ExpectedConditions.visibilityOf(firstName));
		
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys(" ");
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);
		
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("a");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.clear();
		firstName.sendKeys("ab");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.clear();
		firstName.sendKeys("asdfghjkiuytrew");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.clear();
		firstName.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfgh");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		firstName = driver.findElement(By.id("input-firstname"));
		firstName.clear();
		firstName.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfghe");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);
		
		// Last Name
				
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		String lastNameHeigth = lastName.getCssValue("height");
		String lastNameWidth = lastName.getCssValue("width");
		Assert.assertEquals(lastNameHeigth, expectedHeight);
		Assert.assertEquals(lastNameWidth, expectedWidth);
		
		lastName = driver.findElement(By.id("input-lastname"));
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(" ");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();

		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);
		
		lastName = driver.findElement(By.id("input-lastname"));
		lastName.clear();
		lastName.sendKeys("a");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		lastName = driver.findElement(By.id("input-lastname"));
		lastName.clear();
		lastName.sendKeys("ab");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		lastName = driver.findElement(By.id("input-lastname"));
		lastName.clear();
		lastName.sendKeys("asdfghjkiuytrew");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		lastName = driver.findElement(By.id("input-lastname"));
		lastName.clear();
		lastName.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfgh");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		lastName = driver.findElement(By.id("input-lastname"));
		lastName.clear();
		lastName.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfghe");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);
		
		//last name ends
		//Email Field
		
		WebElement email = driver.findElement(By.id("input-email"));

		String emailHeigth = email.getCssValue("height");
		String emailWidth = email.getCssValue("width");
		Assert.assertEquals(emailHeigth, expectedHeight);
		Assert.assertEquals(emailWidth, expectedWidth);
		
		wait.until(ExpectedConditions.visibilityOf(email));
		
		email = driver.findElement(By.id("input-email"));
		email.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfghthy@gmail.com");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		//Email Ends
		//Telephone start
		
		WebElement telephone = driver.findElement(By.id("input-telephone"));
		
		String telephoneHeigth = telephone.getCssValue("height");
		String telephoneWidth = telephone.getCssValue("width");
		Assert.assertEquals(telephoneHeigth, expectedHeight);
		Assert.assertEquals(telephoneWidth, expectedWidth);
		
		telephone = driver.findElement(By.id("input-telephone"));
		wait.until(ExpectedConditions.visibilityOf(telephone));
		telephone.sendKeys(" ");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();

		String expectedtelephoneWarning = "Telephone must be between 3 and 32 characters!";
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedtelephoneWarning);
		
		telephone = driver.findElement(By.id("input-telephone"));
		telephone.clear();
		telephone.sendKeys("12");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedtelephoneWarning);
		
		telephone = driver.findElement(By.id("input-telephone"));
		telephone.clear();
		telephone.sendKeys("123");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		telephone = driver.findElement(By.id("input-telephone"));
		telephone.clear();
		telephone.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfg");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		telephone = driver.findElement(By.id("input-telephone"));
		telephone.clear();
		telephone.sendKeys("qwertyuiopasdfghjklmnbvcxzasdfghe");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedtelephoneWarning);
		
		//telephone ends
		//Password Start
		
		WebElement password = driver.findElement(By.id("input-password"));
		String passWordHeigth = password.getCssValue("height");
		String passWordWidth = password.getCssValue("width");
		Assert.assertEquals(passWordHeigth, expectedHeight);
		Assert.assertEquals(passWordWidth, expectedWidth);
		
		password = driver.findElement(By.id("input-password"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("12");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		String expectedpasswordWarning = "Password must be between 4 and 20 characters!";
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedpasswordWarning);
		
		password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("1234");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("12345698778945612365");
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		} catch (Exception e){
			Assert.assertTrue(true);
					}
		
		//Password Ends

		String passwordConfirmHeigth = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String passwordConfirmWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		Assert.assertEquals(passwordConfirmHeigth, expectedHeight);
		Assert.assertEquals(passwordConfirmWidth, expectedWidth);
		
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Harip\\eclipse-workspace\\LiveAutomation\\ScreenShot\\actualAlignment.png");
		try {
			FileUtils.copyFile(screenshotAs, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertFalse(Utilitis.compareTwoScreenshot(System.getProperty("user.dir")+"\\ScreenShot\\actualAlignment.png",
				System.getProperty("user.dir")+"\\ScreenShot\\expectedAlignment.png"));

		driver.quit();
	}

}
