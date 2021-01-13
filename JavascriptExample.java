import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//JavascriptExecutor js = (JavascriptExecutor)chromeDriver;
		//js.executeScript("window.scroll(0,500)");
		//Thread.sleep(2000);
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> valuesColumn = chromeDriver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int total=0;
		
		for (WebElement value : valuesColumn) {
			total+=Integer.parseInt(value.getText());
			
		}
		
		System.out.println(total);
		int expected = Integer.parseInt((chromeDriver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()));
		Assert.assertEquals(total, expected);
	}

}
