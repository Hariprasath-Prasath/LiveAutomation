package tutorials.Register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.Utilitis;

public class TC_RF_010 {
	
	@Test
	public void verifyRegisteringAccountwithInvalidEmail() throws IOException, InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Mohan");
		driver.findElement(By.id("input-lastname")).sendKeys("Kumar");
		driver.findElement(By.id("input-email")).sendKeys("amotoori");
		driver.findElement(By.id("input-telephone")).sendKeys("1234569870");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File screenshotAs = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, new File(System.getProperty("user.dir")+"\\ScreenShot\\Sc1Actual.png"));

		Assert.assertFalse(Utilitis.compareTwoScreenshot(System.getProperty("user.dir")+"\\ScreenShot\\Sc1Actual.png",
				System.getProperty("user.dir")+"\\ScreenShot\\Sc1Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("amotoori@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File screenshotAs2 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs2, new File(System.getProperty("user.dir")+"\\ScreenShot\\Sc2Actual.png"));
		
		Assert.assertFalse(Utilitis.compareTwoScreenshot(System.getProperty("user.dir")+"\\ScreenShot\\Sc2Actual.png",
				System.getProperty("user.dir")+"\\ScreenShot\\Sc2Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("amotoori@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expectedWarningMessage);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("amotoori@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File screenshotAs3 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs3, new File(System.getProperty("user.dir")+"\\ScreenShot\\Sc3Actual.png"));
		
		Assert.assertFalse(Utilitis.compareTwoScreenshot(System.getProperty("user.dir")+"\\ScreenShot\\Sc3Actual.png",
				System.getProperty("user.dir")+"\\ScreenShot\\Sc3Expected.png"));
		
		driver.quit();
		
	}
}
