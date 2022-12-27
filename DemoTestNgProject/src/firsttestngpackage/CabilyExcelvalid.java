package firsttestngpackage;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CabilyExcelvalid {
	public WebDriver driver;
	public String baseUrl="https://ecabily-testing.zoplay.com/v1.0/rider/signup?data=KzkxJiY4ODI1NjQ0MDE4&";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
	WebDriverWait wait;
	File src;
	
	
  @Test(priority=0)
  public void Cabilyregister() throws IOException,Exception{
	 src=new File("D:\\Afsal\\Cabilydata.xls");
	  FileInputStream cabilyres=new FileInputStream(src);
	  workbook=new HSSFWorkbook(cabilyres);
	  sheet=workbook.getSheet("Sheet3");
	  for(int i=1;i<=2;i++) {
		  cell=sheet.getRow(i).getCell(0);
		  cell.setCellType(Cell.CELL_TYPE_STRING);
		  driver.findElement(By.name("email")).clear();
		  driver.findElement(By.name("email")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.name("email")).sendKeys(cell.getStringCellValue());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']")).click();
		Thread.sleep(2000);
		wait=new WebDriverWait(driver,40);
		WebElement ErrorMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailErr")));
		String mail=ErrorMsg.getText();
		 FileOutputStream Cabilymsg=new FileOutputStream(src);
		 sheet.getRow(i).createCell(1).setCellValue(mail);
		  workbook.write(Cabilymsg);
		  Cabilymsg.close();
	  }
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(1000);
  }
  @Test(priority=1)
  public void Cabilyregister1()throws IOException,Exception{
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-150)");
		 Thread.sleep(1000);
	 src=new File("D:\\Afsal\\Cabilydata.xls");
	 FileInputStream cabilyres=new FileInputStream(src);
	 workbook=new HSSFWorkbook(cabilyres);
	 sheet=workbook.getSheet("Sheet3");
	  for(int i=3;i<=4;i++) {
		  cell=sheet.getRow(i).getCell(0);
		  cell.setCellType(Cell.CELL_TYPE_STRING);
		  driver.findElement(By.name("email")).clear();
		  Thread.sleep(2000);
		  driver.findElement(By.name("email")).sendKeys(cell.getStringCellValue());
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']")).click();
		  Thread.sleep(1000);
		  WebElement ErrorMsg=driver.findElement(By.xpath("//label[contains(text(),'Please enter a valid email address.')]"));
		  String message=ErrorMsg.getText();
		  FileOutputStream Cabilymsg=new FileOutputStream(src);
			 sheet.getRow(i).createCell(1).setCellValue(message);
			  workbook.write(Cabilymsg);
			  Cabilymsg.close();
		  
	  }
  }
  
  
  
@BeforeTest
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", Driverpath);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(25 , TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  
  }


  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(1000);
	  driver.close();
	  
  }

}
