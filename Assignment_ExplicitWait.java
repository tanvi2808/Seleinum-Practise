import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		
		 WebDriver driver = new ChromeDriver();
		 
		 WebDriverWait wait = new WebDriverWait(driver,5);
		 
		 driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		 
		 driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
		 
		 
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("results")));
		 
		// wait.until(ExpectedConditions.fr
		 
		 System.out.println(driver.findElement(By.id("results")).getText());
	
		 
		 
		 
		 
	}
}
