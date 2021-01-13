import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "/Users/tanvi/Documents/automation_testing/chromedriver");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com/?gws_rd=ssl");
			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File("/Users/tanvi/Documents/screenshot.png"));
			
			
			
	}

}
