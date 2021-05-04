
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {
	public static int sizeOfVeggieList;
	public static int totPrice;
	public static String secondUrl = "https://rahulshettyacademy.com/seleniumPractise/#/cart";
	
	public void validateFunc(int quantity, int priceTotal){
		if(totPrice ==priceTotal && sizeOfVeggieList == quantity) {
			System.out.println("Validation Successful!!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		GreenKart gk = new GreenKart();
		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		driver.get(url);							//-----Enter Website-----
		driver.manage().window().maximize();	
		Thread.sleep(2000);
		
		int size = 0;
		List<WebElement> alist = new ArrayList<WebElement>();			//----- List of Vegetables -----
		
		alist = driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(alist);
		String[] vegArray = {"Carrot", "Beans", "Brinjal"};		// --------- Array of Veggies we want----
		List<String> veggieList = Arrays.asList(vegArray);			// ---------List of veggies we want from array ------ veggieList
		int count=0;
		sizeOfVeggieList = veggieList.size();					// ------- sizeOfVeggieList
		String vegName,finalVegName; 
		String vegProductName;
		int brocolliCount, cucumberCount;
		int priceofOne =0, priceBroc=0, priceCucu = 0;
		totPrice = 0;
				
		for(int i=0; i<alist.size(); i++) {
			vegName = alist.get(i).getText();
			String[] splitVegName = vegName.split(" - ");
			finalVegName = splitVegName[0];
			if(veggieList.contains(finalVegName)) {
				count=count+1;
				if(finalVegName.contains("Carrot")) {
					driver.findElements(By.cssSelector("a.increment")).get(i).click();
					brocolliCount = 2;
					Thread.sleep(500);
					driver.findElements(By.cssSelector("div.product-action")).get(i).click();    //-----Add to Cart----
					priceBroc = brocolliCount * Integer.parseInt(driver.findElements(By.xpath("//h4[@class='product-name']/following-sibling::p")).get(i).getText());
					totPrice = totPrice+priceBroc;
					
				}else if(finalVegName.contains("Beans")) {
					driver.findElements(By.cssSelector("input.quantity")).get(i).clear();
					driver.findElements(By.cssSelector("input.quantity")).get(i).sendKeys("3");				
					cucumberCount = 3;			
					Thread.sleep(500);
					driver.findElements(By.cssSelector("div.product-action")).get(i).click();	 //-----Add to Cart----	
					priceCucu = cucumberCount * Integer.parseInt(driver.findElements(By.xpath("//h4[@class='product-name']/following-sibling::p")).get(i).getText());
					totPrice = totPrice+priceCucu;
				}else {
					driver.findElements(By.cssSelector("div.product-action")).get(i).click();	 //-----Add to Cart----
					priceofOne = Integer.parseInt(driver.findElements(By.xpath("//h4[@class='product-name']/following-sibling::p")).get(i).getText());
					totPrice = totPrice +priceofOne;
				}
				
				if(count == sizeOfVeggieList) {
					break;
				}
			}
					
		}
		System.out.println("Calculated Total Price : "+totPrice);
		Thread.sleep(7000);
		
		 //VALIDATION
		
		List<WebElement> cartInfo = new ArrayList<WebElement>();
		cartInfo = driver.findElements(By.cssSelector("div.cart-info strong"));
		int quantity = Integer.parseInt(cartInfo.get(0).getText());
		int priceTotal = Integer.parseInt(cartInfo.get(1).getText());
		System.out.println("cart-info quantity = "+quantity);
		System.out.println("cart-info price = "+priceTotal);
		
		gk.validateFunc(quantity, priceTotal);	//------- Validating ------------

		
		driver.findElement(By.cssSelector("a.cart-icon")).click();		// ------ Click on Cart------
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.cart-preview.active button")).click();		//----- click on Proceed to Checkout----- 
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equalsIgnoreCase(secondUrl)) {
			System.out.println("Second page is Validated");
		}
		Thread.sleep(3000);
		//VALIDATION IN SECOND PAGE
		List<WebElement> productList = new ArrayList<WebElement>();
		productList = driver.findElements(By.cssSelector("p.product-name"));
		for(int j=0; j<productList.size(); j++) {
			vegProductName = productList.get(j).getText();
			if(vegProductName.contains(veggieList.get(j))) {
				System.out.println(vegProductName+" is correct");
			}
		}
		List<WebElement> quantityList = new ArrayList<WebElement>();
		quantityList = driver.findElements(By.cssSelector("p.quantity"));
		//int numItems =Integer.parseInt(driver.findElement(By.xpath("//div[@class='products']/div/b[1]")).getText());		//------ERROR---------
		String test = driver.findElement(By.xpath("//div[@class='promoWrapper']/following-sibling::b[1]")).getText();
		//int numItems = Integer.parseInt(driver.findElement(By.xpath("//div[@class='promoWrapper']/following-sibling::b[1]")).getText());
		System.out.println(test);
		int totAmt = Integer.parseInt(driver.findElement(By.className("totAmt")).getText());
		Thread.sleep(1000);
		System.out.println("Second Page Validation:");
		//gk.validateFunc(numItems, totAmt);
		
		driver.quit();
	}

}
