package practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelPractice {
	public static void main (String [] args) throws IOException{

		File src=new File(".//data//Book1.xlsx");
		FileInputStream fs=new FileInputStream(src);
		
		//tableElement= driver.findElements(By.cssSelector("div.Collapsible__contentInner table tbody tr td"));
		//System.out.println("Size of tableElements = "+tableElement.size());
		//Creating a workbook
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.getSheet("Sheet1"); // wb.getSheetAt(0);
//		int totalrows = sheet.getLastRowNum();
//		int totalcol = sheet.getRow(0).getLastCellNum();
//		System.out.println("rows:"+totalrows+" cols:"+totalcol);
		XSSFRow row;
		XSSFCell cell;
		//For Writing into the excel file
		FileOutputStream fo=new FileOutputStream(src);
		sheet.getRow(1).createCell(2).setCellValue("Pass");
		sheet.getRow(2).createCell(2).setCellValue("Pass");
		wb.write(fo);
		//Loop for reading from excel file
//		for(int r=0; r<=totalrows; r++) {
//			row= sheet.getRow(r);
//			for(int c=0; c<totalcol; c++) {
//				cell = row.getCell(c);
//				switch(cell.getCellType()) {
//				case STRING: System.out.print(cell.getStringCellValue()); break;
//				case NUMERIC: System.out.print(cell.getNumericCellValue());break;
//				case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
//				default: System.out.println("not correct");
//				}
//				System.out.print(" | ");
//			}System.out.println();
//		}
		
		wb.close();
	}
}


//public class ExcelPractice {
//
//	public static void main(String[] args) throws IOException {
////		System.setProperty("webdriver.chrome.driver", "//Users//sandeep//eclipseJXworkspace//Driver//chromedriver");
////		WebDriver driver = new ChromeDriver();
////		String url = "https://www.espncricinfo.com/series/ipl-2021-1249214/mumbai-indians-vs-chennai-super-kings-27th-match-1254084/full-scorecard";
////		driver.get(url);
////		driver.manage().window().maximize();
//		
////		List<WebElement> tableElement = new ArrayList<WebElement>();
////		
////		tableElement= driver.findElements(By.cssSelector("div.Collapsible__contentInner table tbody tr td"));
//		File file =    new File("/Users/sandeep/Desktop/output.xlsx");
//		FileInputStream fis= new FileInputStream(file);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("TestDate");
//		Row row = sheet.createRow(1);
//		Cell cell = row.createCell(1);
//		//cell.setCellType(cell.CELL_TYPE_STRING);
//		cell.setCellValue("SoftwareTestingMaterial.com");
//		FileOutputStream fos = new FileOutputStream("/Users/sandeep/Desktop/output.xlsx");
//		wb.write(fos);
//		fos.close();
//		System.out.println("END OF WRITING DATA IN EXCEL");
//		//
//	}
//
//}

