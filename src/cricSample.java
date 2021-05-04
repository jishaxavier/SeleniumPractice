import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cricSample {
	public static void scrnShot(WebDriver driver, String path) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File imgFile = sc.getScreenshotAs(OutputType.FILE);
		String partPath="/Users/sandeep/Desktop/TestShots/";
		FileUtils.copyFile(imgFile,new File(partPath+path+".jpeg"));
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.espncricinfo.com/series/ipl-2021-1249214/mumbai-indians-vs-chennai-super-kings-27th-match-1254084/full-scorecard";
		driver.get(url);
		driver.manage().window().maximize();
		try {
			scrnShot(driver, "testscn");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> teams = new ArrayList<WebElement>();
		teams = driver.findElements(By.cssSelector("div.card.content-block.match-scorecard-table div.Collapsible"));
		WebElement mumbaiTable;
		List<WebElement> runs = new ArrayList<WebElement>();
		String teamName;
		int sum=0;
		for(int i=0; i<teams.size(); i++) {
			mumbaiTable = teams.get(i);
			teamName= mumbaiTable.findElement(By.cssSelector("div.col h5")).getText();
			System.out.println(teamName);
			if(teamName.contains("MUMBAI")) {
				runs= mumbaiTable.findElements(By.cssSelector("table.table.batsman tbody td:nth-child(3)"));
				for(int k=0; k<runs.size(); k++) {
					sum=sum+Integer.parseInt(runs.get(k).getText());
					System.out.println(runs.get(k).getText());
					
				}System.out.println("Sum = "+sum);
			}
		}
		
		driver.quit();
	}

}
//table.table.batsman tbody td:nth-child(1) a
//https://www.toolsqa.com/selenium-webdriver/excel-in-selenium/