package tutorials.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Utilitis;

public class TC_RF_027 {
	
	@Test(dataProvider = "environmentsSupplier")
	public void verifyRegistringAccountWithDifferentEnvironments(String env) {
		
		String browserName = env;
		WebDriver driver = null;
		
		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equals("fireFox")) {
		    driver = new FirefoxDriver();
		} else if(browserName.equals("eage")) {
		    driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Mohan");
		driver.findElement(By.id("input-lastname")).sendKeys("Raj");
		driver.findElement(By.id("input-email")).sendKeys(Utilitis.getNewMailID());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
		Assert.assertEquals(driver.getTitle(), "My Account");
		
		driver.quit();
		
	}
	
	@DataProvider(name = "environmentsSupplier")
	public Object[][] passTestEnvironments() {
		
		Object[][] envs = {{"Chrome"},{"fireFox"},{"eage"}};
		return envs;
		
	}

}
