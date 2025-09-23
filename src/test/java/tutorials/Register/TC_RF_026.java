package tutorials.Register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_026 {
	
	WebDriver driver;
	
	@Test
	public void verifyUIOfRegisterAccount() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Harip\\eclipse-workspace\\LiveAutomation\\ScreenShot\\actialUI.png");
		try {
			FileUtils.copyFile(screenshotAs, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Assert.assertTrue(Utilitis.compareTwoScreenshot("C:\\Users\\Harip\\eclipse-workspace\\LiveAutomation\\ScreenShot\\actialUI.png",
					"C:\\Users\\Harip\\eclipse-workspace\\LiveAutomation\\ScreenShot\\expectedUI.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
