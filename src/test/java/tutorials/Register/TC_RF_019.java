package tutorials.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_019 {
	
	WebDriver driver;
	
	@Test
	public void verifyLeadingAndTrailingPaceWhileRegisteringAccount(){
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String enterFirstName = "    Mohan   ";
		driver.findElement(By.id("input-firstname")).sendKeys(enterFirstName);
		
		String enterLastName = "   T    ";
		driver.findElement(By.id("input-lastname")).sendKeys(enterLastName);
		
		String enterEmailId = "   "+Utilitis.getNewMailID()+"   ";
		driver.findElement(By.id("input-email")).sendKeys(enterEmailId);
		
		String enterTelephoneNunber = "  "+"1234567890"+"  ";
		driver.findElement(By.id("input-telephone")).sendKeys(enterTelephoneNunber);
		
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']")).click();
		
		driver.findElement(By.linkText("Edit your account information")).click();
		
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), enterFirstName.trim());
		
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), enterLastName.trim());
		
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), enterEmailId.trim());
		
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), enterTelephoneNunber.trim());
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
