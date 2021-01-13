import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("No of rows = "+ driver.findElements(By.cssSelector(".table-display tr")).size());
		System.out.println("No of columns = " + driver.findElements(By.cssSelector(".table-display tr:nth-child(1) th")).size());
System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		//		List<WebElement> secondRowColumns = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
//		for(WebElement col : secondRowColumns) {
//			System.out.println(col.getText());
//		}
	}

}
