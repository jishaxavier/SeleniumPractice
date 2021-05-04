import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.spicejet.com/";
		driver.get(url);							//-----Enter Website-----
		driver.manage().window().maximize();		//----FullScreen
		//Select radio button Roundtrip
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
		//Select checkboxes
		driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_Govt")).click();
		driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_friendsandfamily")).click();
		Thread.sleep(2000);
		//Select Source and destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Ajmer");
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='GOI']")).click();
	
		Thread.sleep(2000);
		//Select Currency
		WebElement currency=driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		Select currencySelect = new Select(currency);
		currencySelect.selectByValue("USD");
		
		Thread.sleep(2000);
		
		
		
		
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();
		Thread.sleep(1000);
		//Adult Count
		WebElement adultCount;
		adultCount= driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Adult"));
		Select adultSelect = new Select(adultCount);
		adultSelect.selectByValue("4");
		//Child Count
		WebElement childCount;
		childCount = driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Child"));
		Select childSelect = new Select(childCount);
		childSelect.selectByValue("2");
		//Infant Count
		WebElement infantCount;
		infantCount = driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Infant"));
		Select infantSelect = new Select(infantCount);
		infantSelect.selectByValue("1"); 
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		

	}

}
