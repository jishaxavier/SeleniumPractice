import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDownSAmple {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
	WebDriver driver = new ChromeDriver();
	//driver.get("https://www.espncricinfo.com/");
	//"https://www.spicejet.com/";
	String url="http://demo.guru99.com/test/delete_customer.php";
	driver.get(url);
	driver.manage().window().maximize();
	
	driver.findElement(By.name("cusid")).sendKeys("xyz");
	driver.findElement(By.name("submit")).click();
	
	Alert a1 = driver.switchTo().alert();	//----- Alert box using Alert class
	String alerttext= a1.getText();
	System.out.println(alerttext);
	Thread.sleep(2000);
	a1.accept();
	Thread.sleep(3000);
	
	
	
	
	/*WebElement wb;
	wb=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
	
	Select dropselect = new Select(wb);
	
	dropselect.selectByIndex(2);
	Thread.sleep(2000);
	dropselect.selectByValue("AED");
	Thread.sleep(2000);
	dropselect.selectByVisibleText("USD");
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//input(@id='sctl00_mainContent_rbtnl_Trip_1']")).click();
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
	
	parent=driver.findElement(By.id("glsctl00_mainContent_ddl_destinationStation1_CTNR"));
		parent.findElement(By.xpath("//a[@value='BLR']")).click();
		CssSelector Parent/child
	$("div[id='glsctl00_mainContent_ddl_originStation1_CTNR'] a[value='BLR']")
	
	
	
	Thread.sleep(2000);
	WebElement wb2, wb3;
	wb2=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_Govt']"));
	wb3=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_IndArm']"));
	if(!wb2.isSelected()) {
		wb2.click();
		
	}
	Thread.sleep(1000);
	if(!wb3.isSelected()) {
		wb3.click();
	}
	Thread.sleep(1000);
	if(wb2.isSelected()) {
		System.out.println("it is selected");
		wb2.click();
	}
//	driver.findElement(By.xpath("//input(@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
//	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_Govt']")).click();
	Thread.sleep(2000);*/
	
	driver.quit();
	
}
}
