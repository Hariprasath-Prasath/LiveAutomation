package tutorials.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
	
	@Test
	public void verifingRegisterAccountUsingMultileWays(){
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://tutorialsninja.com/demo");;
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		String registerVerification = "Register Account";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1[text()='Register Account']")).getText(), registerVerification);
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//aside[@id='column-right']//a[text()='Register']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1[text()='Register Account']")).getText(), registerVerification);
		
		driver.quit();
		
	}

}
