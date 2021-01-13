import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
	
	static WebDriver driver ;
	static WebDriverWait w ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] veges = {"Beetroot","Beans","Potato","Onion"};
		
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		
		 driver = new ChromeDriver();
		 w = new WebDriverWait(driver, 5);
		 
		 // make implicit wait of 5 sec  
		 //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// get the url page
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		// add the veges to the cart
		addItemsToCart(driver, veges);
		
		// click on "Proceed tp checkout
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		// apply promocode
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		

	} // end of main
	
	public static void addItemsToCart(WebDriver driver, String[] itemsToAdd) {
		
List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		
		List<String> vegesList = Arrays.asList(itemsToAdd);
		int numOfItemsAdded = 0;
		
		for(int i =0; i<products.size();i++) {
			
			//find the index of vegetable to be added and then click add to cart button at that index
			//System.out.println(products.get(i).getText());
			String name = (products.get(i).getText().split("-"))[0].trim();
			//System.out.println(name);
			if(vegesList.contains(name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				numOfItemsAdded++;
				
				if(vegesList.size()==numOfItemsAdded)
					break;
				
				
			}
		}
		
	}

}
