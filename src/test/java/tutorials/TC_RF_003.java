package tutorials;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	
	@Test
	public void verifyRegisterAccountWithAllFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Kumar");
		
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String expectedProperDetails1 = "Your Account Has Been Created!";
		String expectedProperDetails2 = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetails3 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetails4 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetails5 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expectedProperDetails6 = "contact us";
		
		String actualProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails1));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails2));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails3));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails4));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails5));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetails6));
		
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
	}
	
	public String generateNewEmail() {
		//method chaining mechanism
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
	}

}
