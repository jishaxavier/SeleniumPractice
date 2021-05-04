import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoPrac {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		
		List<WebElement> links = new ArrayList<WebElement>();
		links = driver.findElements(By.cssSelector("div.footer_top_agile_w3ls.gffoot.footer_style td a"));
		for(int i=0; i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}
				
		driver.quit();
	}

}
