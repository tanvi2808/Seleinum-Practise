import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// print the number of links on whole page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//print the number of links in footer
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		// print the number of links under 1st column in footer
		
		WebElement column1 = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		List<WebElement> links = column1.findElements(By.tagName("a"));
	
		String openNewTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
		
		for(int i=1;i<links.size();i++) {
			
			links.get(i).sendKeys(openNewTab);;
			
		}
		
		Set<String> linksOpened = driver.getWindowHandles();
		
		Iterator it = linksOpened.iterator();
		
		while(it.hasNext()) {
			String windowId = (String) it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getTitle());
		}
		
		
		
		
		
		
		
		
		

	}

}
