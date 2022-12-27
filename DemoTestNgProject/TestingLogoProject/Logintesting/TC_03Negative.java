package Logintesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

@Test
public class TC_03Negative {
	public WebDriver driver;
	public String baseUrl = "http://192.168.1.16/phpmongo/admin";
	String Driverpath = "C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	File  src=new File("D:\\Afsal\\Datas.xls");
  public void Testcase()throws Exception {
	  FileInputStream finput=new FileInputStream(src);
	  workbook=new HSSFWorkbook(finput);
	  sheet=workbook.getSheet("Sheet1");
	  for(int i=1;i<=sheet.getLastRowNum();i++) {
		  cell=sheet.getRow(i).getCell(0);
	       cell.setCellType(Cell.CELL_TYPE_STRING);
	       driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
	  driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(cell.getStringCellValue());
	  Thread.sleep(2000);
	  cell=sheet.getRow(i).getCell(1);
      cell.setCellType(Cell.CELL_TYPE_STRING);
      driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(cell.getStringCellValue());
		Thread.sleep(2000);
		 wait = new WebDriverWait(driver,5);
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='frm-submit']")));
		login.click();
		FileOutputStream foutput=new FileOutputStream(src);
		
	 WebElement message= driver.findElement(By.cssSelector("body:nth-child(2) > script:nth-child(13)"));
		String Message1= (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", message);
		  
			 sheet.getRow(i).createCell(2).setCellValue("Error\n"+
			 "Invalid Login Details!!!");
			 System.out.println(Message1);
	       
	      workbook.write(foutput); 
	 	  foutput.close();
	  
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", Driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
