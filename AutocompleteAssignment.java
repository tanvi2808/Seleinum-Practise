import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutocompleteAssignment {
	
	static String country = "United Kingdom";

	 public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		 
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 
		 ChromeOptions options = new ChromeOptions();
		 options.merge(capabilities);
		 
		 
		 
		 WebDriver driver = new ChromeDriver(options);
		
		 
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 
		 driver.findElement(By.id("autocomplete")).sendKeys("Uni");
		 Thread.sleep(1000);
		 
//		 List<WebElement> values = driver.findElements(By.cssSelector("#ui-id-1 li"));
//		 for(WebElement value : values) {
//			// System.out.println(value.getText());
//			 if(value.getText().contains(country)) {
//				 value.click();
//				 break;
//			 }
//			}
		 
		 for(int i=0; i<5;i++)
			 	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			 
		 System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		 
		 
		//Assert.assertTrue( driver.findElement(By.id("autocomplete")).getAttribute("value").contains(country));
		// System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		 	
	 }
	
}
