package tutorials.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_014 {
	
	WebDriver driver;
	
	@Test
	public void verifyMandatoryFieldsSymbolAndColorInRegisterAccoundPage() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedFNContent = "\"* \"";
		String expectedFnColor = "rgb(255, 0, 0)";
		
		WebElement firstNameLable = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String firstName = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", firstNameLable);
		String color = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", firstNameLable);
		Assert.assertEquals(firstName, expectedFNContent);
		Assert.assertEquals(color, expectedFnColor);
		
		WebElement lastNameLable = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		String lastName = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", lastNameLable);
		String lastNamecolor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", lastNameLable);
		Assert.assertEquals(lastName, expectedFNContent);
		Assert.assertEquals(lastNamecolor, expectedFnColor);
		
		WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		String emailContent = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", emailLabel);
		String emailColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", emailLabel);
		Assert.assertEquals(emailContent, expectedFNContent);
		Assert.assertEquals(emailColor, expectedFnColor);
		
		WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		String telephoneContent = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", telephoneLabel);
		String telephoneColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", telephoneLabel);
		Assert.assertEquals(telephoneContent, expectedFNContent);
		Assert.assertEquals(telephoneColor, expectedFnColor);
		
		WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
		String passwordContent = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", passwordLabel);
		String passwordColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", passwordLabel);
		Assert.assertEquals(passwordContent, expectedFNContent);
		Assert.assertEquals(passwordColor, expectedFnColor);
		
		WebElement passwordConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		String passwordConfirmContent = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", passwordConfirmLabel);
		String passwordConfirmColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", passwordConfirmLabel);
		Assert.assertEquals(passwordConfirmContent, expectedFNContent);
		Assert.assertEquals(passwordConfirmColor, expectedFnColor);
		
		WebElement privacyPolicyLabel = driver.findElement(By.cssSelector("[class='buttons']"));
		String privacyPolicyContent = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content')", privacyPolicyLabel);
		String privacyPolicyColor = (String)js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color')", privacyPolicyLabel);
		Assert.assertEquals(privacyPolicyContent, expectedFNContent);
		Assert.assertEquals(privacyPolicyColor, expectedFnColor);
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
