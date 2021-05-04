import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.espncricinfo.com/");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement webE;
		//Using CSSCELECTOR
//		driver.findElement(By.cssSelector("i.espn-icon.icon-search-solid-after.icon-.text-light")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[name = 'search']")).sendKeys("South Africa");
//		driver.findElement(By.cssSelector("button[type = 'submit']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("a[href='/ci/engine/match/1251576.html']")).click();
//		Thread.sleep(5000);
//		driver.quit();
		
		//Using XPATH
//		driver.findElement(By.xpath("//i[@class='espn-icon.icon-search-solid-after.icon-.text-light']")).click();
//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("India");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
//		driver.findElement(null)
//		driver.quit();
		
		//driver.findElement(By.xpath("//div[@class='SDkEP']/div[2]/input")).sendKeys("Hey Google");
		//driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("Heylo");
		//driver.findElement(By.xpath("//div[@class ='RNNXgb']/div/div[2]/input")).sendKeys("Yolo");
		try {
			//driver.findElement(By.xpath("//div[@class='LX3sZb']/preceding-sibling::a[2]")).click();
			driver.findElement(By.xpath("//a[@class"));
		}
		finally {
			Thread.sleep(5000);
			driver.quit();
		}
			
	}

}
