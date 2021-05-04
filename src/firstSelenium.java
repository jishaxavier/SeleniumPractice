import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class firstSelenium {

	public static void main(String[] args) throws InterruptedException {
		//Scanner sc = new Scanner(System.in);
//		System.out.println("Browesers available: Chrome, Firefox");
//		System.out.println("Please Enter your preferred Browser: ");
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver chrome = new ChromeDriver();
		chrome.get("https://www.facebook.com/");
		//String browser = sc.nextLine();
//		if(browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
//			WebDriver chrome = new ChromeDriver(); 
//			chrome.get("https://www.google.com/");
//		}else if(browser.equalsIgnoreCase("Firefox")) {
//			//System.setProperty("webdriver.gecko.driver", "//Users//sandeep//eclipseJXworkspace//Driver//geckodriver");
//			System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
//			WebDriver gecko = new ChromeDriver();
//			gecko.get("https://www.facebook.com/");
//		}else {
//			System.out.println("Sorry, wrong entry!");
//		}
//		
		WebElement wb;
		wb = chrome.findElement(By.id("email"));
		wb.sendKeys("jishax@gmail.com");
		Thread.sleep(5000);
		wb = chrome.findElement(By.name("email"));
		wb.clear();
		//wb=chrome.findElement(By.linkText("Forgot Password?"));
		//wb.click();
		//wb=chrome.findElement(By.partialLinkText("Forgot"));
		//wb.click();
		
		//xpath formula: //tagname[@attribute_name = 'value']
		
		wb = chrome.findElement(By.xpath("//input[@name='email']"));
		chrome.findElement(By.xpath("//input[@name='email']")).sendKeys("from xpath");
		Thread.sleep(2000);
		//CSS SELECTOR  :   tagname[attributeName='value']
//		chrome.findElement(By.cssSelector("input[id='pass']")).sendKeys("from cssSelector");
//		Thread.sleep(2000);
		chrome.findElement(By.cssSelector("input.inputtext._55r1._6luy._9npi")).sendKeys("Pass");
		Thread.sleep(2000);
		chrome.quit();
		
		
//		String pageSource;
//		pageSource = chrome.getPageSource();
//		//System.out.println(pageSource);
//		String currentURL = chrome.getCurrentUrl();
//		String title = chrome.getTitle();
//		//if(title.equals(title)) {
//		//	System.out.println("URL: "+currentURL +" Title: "+ title);
//		//}
//		System.out.println("URL: "+currentURL +" Title: "+ title);
//		//Thread.sleep(5000);
//		chrome.navigate().back();
//		Thread.sleep(5000);
//		chrome.manage().window().maximize();
//		Thread.sleep(5000);
//		chrome.quit(); //quits all the browser
		//wd.close(); //closes the current browser
	}

}
