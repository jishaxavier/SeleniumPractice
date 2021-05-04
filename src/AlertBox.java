import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.espncricinfo.com/");
		String url="http://demo.guru99.com/test/guru99home/";  //"https://www.spicejet.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		//IFRAMES - different window inside a window
		driver.switchTo().frame("a077aa5e");
		 // ---------parentframe
		driver.findElement(By.xpath("//html/body/a/img")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		
		
		driver.quit();
	}

}
