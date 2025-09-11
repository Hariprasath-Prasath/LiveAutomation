package tutorials.Register;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tables {
	
	@Test
	public void table() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		WebElement table = driver.findElement(By.id("customers"));
		
		List<WebElement> tableRow =table.findElements(By.tagName("tr"));
		for(int i = 1; i<tableRow.size(); i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> tabledata = row.findElements(By.tagName("td"));
			for(int j = 0; j<tabledata.size(); j++) {
				WebElement data = tabledata.get(j);
				String text = data.getText();
				if(text.equals("Island Trading")) {
					System.out.println(text);
					
				}
			}	
		}
		
	}

}
