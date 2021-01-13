import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// select a checkbox
		WebElement optionSelected = driver.findElement(By.id("checkBoxOption2"));
		optionSelected.click();
		
		
		// get the title of selected checkbox
		String labelSelected = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(labelSelected);
		
		// choose the label selected in dropdown
		
		//driver.findElement(By.id("dropdown-class-example")).click();
		Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDown.selectByVisibleText(labelSelected);
		
		// add gthe selected label to alert box
		driver.findElement(By.id("name")).sendKeys(labelSelected);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		
		//if(alertMessage.contains(labelSelected)) 
		//	System.out.println("Alert contains " + labelSelected);
		
		Assert.assertTrue(alertMessage.contains(labelSelected));
		

	}

}
