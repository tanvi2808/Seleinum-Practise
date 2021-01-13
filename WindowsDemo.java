import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		//switch to child window
		
		driver.switchTo().window(childId);
		
		String message = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String email = message.split(" ")[4];  // extract the email id from the message
		
		// switch back to the parent window
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		

	}

}
