package tutorials.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_023 {
	
	WebDriver driver;
	WebDriverWait wait;	
	
	@Test
	public void navigatingToCheckingVerifyEveryLinkOnRegisterAccountPage() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.xpath("//a/i[@class='fa fa-phone']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Contact Us']")).isDisplayed());
		driver.navigate().back();
		
		
		driver.findElement(By.xpath("//a[@id='wishlist-total']//span[text()='Wish List (0)']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Shopping Cart']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//span[text()='Checkout']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Shopping Cart']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//div[@id='logo']//a[text()='Qafox.com']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//div[@id='search']//button[@type='button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Search']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		driver.findElement(By.linkText("Account")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
		
		WebElement homeButton = driver.findElement(By.xpath("//ul[@class='breadcrumb']//i[@class='fa fa-home']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeButton);
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		WebElement loginPage = driver.findElement(By.linkText("login page"));
		wait.until(ExpectedConditions.visibilityOf(loginPage));
		loginPage.click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//b[text()='Privacy Policy']")).click();
		WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Privacy Policy']")));
		Assert.assertTrue(expectedElement.isDisplayed());
		driver.findElement(By.xpath("//button[text()='×']")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Continue']")).isDisplayed());
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Login")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		driver.findElement(By.linkText("Forgotten Password")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Forgotten Password']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//div[@class='list-group']//a[text()='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Address Book")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Wish List")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Order History")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Downloads")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Recurring payments")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Reward Points")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Returns")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Transactions")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Newsletter")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("About Us")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='About Us']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Delivery Information")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Delivery Information']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Privacy Policy']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Privacy Policy']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Terms & Conditions")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Terms & Conditions']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Contact Us")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Contact Us']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Returns']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Product Returns']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Site Map")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Site Map']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Brands")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Brand']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Gift Certificates")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Gift Certificate']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Affiliate")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=affiliate/login");
		driver.navigate().back();
		
		driver.findElement(By.linkText("Specials")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Special Offers']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Order History")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Wish List")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.linkText("Newsletter")).click();
		
		driver.quit();
		
	}
	

}
