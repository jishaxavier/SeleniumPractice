import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElementsSandeep {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		List<WebElement> elements= new ArrayList();
		String url="https://www.expedia.com/"; 
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("location-field-leg1-origin-menu")).click();
		
		driver.findElement(By.cssSelector("input#location-field-leg1-origin")).sendKeys("ind");
		Thread.sleep(2000);
		elements=driver.findElements(By.cssSelector("li.uitk-typeahead-result-item.has-subtext strong"));
		String str;
		System.out.println(elements.size());
		for(int i=0; i<elements.size(); i++) {
			str = elements.get(i).getText();
			System.out.println(str);
			
			if(str.contains("Delhi")) {
				elements.get(i).click();
				System.out.println("Delhi is clicked");
				break;
			}
				
		}		
		Thread.sleep(3000);
				
		driver.quit();
	}
}
