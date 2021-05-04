import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpediaPractice {
	public static String fromAirport = "Pearson Intl.";
	public static String toAirport = "Indira Gandhi Intl.";
	public String fromAirportList, toAirportList;
	
	
	public void selectLocation(WebDriver driver,String airportName) {
		List<WebElement> airportList = new ArrayList<WebElement>();
		airportList = driver.findElements(By.cssSelector("li.uitk-typeahead-result-item.has-subtext strong")); 
		for(int i=0; i<airportList.size(); i++) {
			fromAirportList = airportList.get(i).getText();
			if(fromAirportList.contains(airportName)) {
				airportList.get(i).click();
				break;
			}	
		}
	}
	public void selectDate(WebDriver driver, String monthName, int dateNum) throws InterruptedException {
		List<WebElement> months = new ArrayList<WebElement>();
		List<WebElement> dateTable= new ArrayList<WebElement>();
		List<WebElement> btnClick = new ArrayList<WebElement>();
		List<WebElement> dateBtn = new ArrayList<WebElement>();
		int dateVal;
		WebElement datePicker;
		int i=0; //counter
		while(true) {
			months= driver.findElements(By.cssSelector("div.uitk-date-picker-month h2"));
			dateTable=driver.findElements(By.cssSelector("table.uitk-date-picker-weeks"));
			if(months.get(i).getText().contains(monthName)) {
				Thread.sleep(2000);
				datePicker = dateTable.get(i);
				dateBtn=datePicker.findElements(By.cssSelector("tbody tr td button"));
				for(int j=0; j<dateBtn.size(); j++) {
					dateVal = Integer.parseInt(dateBtn.get(j).getAttribute("data-day"));
					if(dateVal==dateNum) {
						dateBtn.get(j).click();
						Thread.sleep(3000);
						break;
					}
				}
				break;
			}
			i++;
			if(i==2) {
				btnClick=driver.findElements(By.xpath("//div[@class='uitk-calendar']/div/button"));
				//for(int m=0;m<btnClick.size();m++) {
					btnClick.get(1).click();
					Thread.sleep(1000);
					btnClick.get(1).click();
				i=0;
			}
					
				
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExpediaPractice expedia = new ExpediaPractice();
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.expedia.com/", fromLocation = "Canada", toLocation ="India";
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Flights")).click();
		//Enter Source
		driver.findElement(By.cssSelector("div#location-field-leg1-origin-menu")).click();
		driver.findElement(By.cssSelector("input#location-field-leg1-origin")).sendKeys(fromLocation);
		Thread.sleep(2000);
		expedia.selectLocation(driver, fromAirport);
		//Enter Destination
		driver.findElement(By.cssSelector("div#location-field-leg1-destination-menu")).click();
		driver.findElement(By.cssSelector("input#location-field-leg1-destination")).sendKeys(toLocation);
		Thread.sleep(2000);
		expedia.selectLocation(driver, toAirport);
		Thread.sleep(2000);
		//Dates
		driver.findElement(By.id("d1-btn")).click();
		Thread.sleep(3000);
		expedia.selectDate(driver,"July",14);
		expedia.selectDate(driver,"August",6);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.uitk-flex.uitk-date-picker-menu-footer button")).click();		
		Thread.sleep(2000);
		driver.quit();
	}

}
