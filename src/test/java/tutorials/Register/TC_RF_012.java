package tutorials.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_012 {
	
	@Test
	public void verifyRegisteringAccountUsingKeyboardKeys() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Actions action = new Actions(driver);
		
		for(int i =0; i<23;i++) {
		action.sendKeys(Keys.TAB).perform();
		}
		
		action.sendKeys("Mohan").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).perform();
		action.sendKeys("Raj").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).perform();
		action.sendKeys(Utilitis.getNewMailID()).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).perform();
		action.sendKeys("1234567890").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).perform();
		action.sendKeys("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).perform();
		action.sendKeys("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ARROW_LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE).perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).perform();
		action.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//aside[@id=\"column-right\"]//a[text()='Logout']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String actualValue = driver.findElement(By.id("content")).getText();
		
		String expetedValue1 = "Your Account Has Been Created!";
		String expetedValue2 ="Congratulations! Your new account has been successfully created!";
		String expetedValue3 ="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expetedValue4 ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expetedValue5 ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String expetedValue6 = "contact us.";
		
		Assert.assertTrue(actualValue.contains(expetedValue1));
		Assert.assertTrue(actualValue.contains(expetedValue2));
		Assert.assertTrue(actualValue.contains(expetedValue3));
		Assert.assertTrue(actualValue.contains(expetedValue4));
		Assert.assertTrue(actualValue.contains(expetedValue5));
		Assert.assertTrue(actualValue.contains(expetedValue6));
		
		driver.quit();
		
	}

}
