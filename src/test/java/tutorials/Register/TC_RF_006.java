package tutorials.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_006 {
	
	@Test
	 public void verifyRegisterAccoutWithNoOption(){
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 driver.get("http://tutorialsninja.com/demo");
		 
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 
		 driver.findElement(By.id("input-firstname")).sendKeys("Hi");
		 driver.findElement(By.id("input-lastname")).sendKeys("Hi");
		 driver.findElement(By.id("input-email")).sendKeys(Utilitis.getNewMailID());
		 driver.findElement(By.id("input-telephone")).sendKeys("0987456321");
		 driver.findElement(By.id("input-password")).sendKeys("12345");
		 driver.findElement(By.id("input-confirm")).sendKeys("12345");
		 driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		 driver.findElement(By.name("agree")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		 Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		 
		 String actualText = driver.findElement(By.id("content")).getText();
		 
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
			
			driver.findElement(By.xpath("//a[text()='Continue']")).click();
			
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			
			driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
			
			Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected());
			
			driver.quit();
		 
	 }
	 
}
