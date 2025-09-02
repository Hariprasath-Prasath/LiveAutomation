package tutorials.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_017 {
	
	WebDriver driver;
	
	
	@Test(dataProvider = "password")
	public void verifyRegisteringAccoutCheckingPasswordComplexityStandards(String passWords) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mohan");
		driver.findElement(By.id("input-lastname")).sendKeys("Raj");
		driver.findElement(By.id("input-email")).sendKeys(Utilitis.getNewMailID());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.id("input-password")).sendKeys(passWords);
		driver.findElement(By.id("input-confirm")).sendKeys(passWords);
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String warningMessage = "Size of password as 8, password should contain atleat one number, symbol, lower case letter and upper case letters";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), warningMessage);
		
		Assert.assertFalse(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		
	}
	
	@DataProvider(name = "password")
	public Object[][] supplyPasswords() {
		Object[][] data = {{"12345"},{"abcdefg"},{"abcd1234"},{"abcd123$"},{"ABCD123#"}};
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
