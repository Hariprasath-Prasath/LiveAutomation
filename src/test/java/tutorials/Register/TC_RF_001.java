package tutorials.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public void verifyRegisterWithMandatoryFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Hari");
		driver.findElement(By.id("input-lastname")).sendKeys("T");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		String actualproperDetails1 = "Congratulations! Your new account has been successfully created!";
		String actualproperDetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualproperDetails3 ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualproperDetails4 = "contact us";
		
		String ExpectedProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(ExpectedProperDetails.contains(actualproperDetails1));
		Assert.assertTrue(ExpectedProperDetails.contains(actualproperDetails2));
		Assert.assertTrue(ExpectedProperDetails.contains(actualproperDetails3));
		Assert.assertTrue(ExpectedProperDetails.contains(actualproperDetails4));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
	}

	public String generateNewEmail() {
		//method chaining mechanism
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
	}
	
}
