package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Validationcabily {
	public WebDriver driver;
	public String baseUrl="https://cabily-e.zoplay.com/admin";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
  @Test(dataProvider = "cabilyData")
  public void testcase(String username, String password)throws Exception {
File src=new File("D:\\Afsal\\Cabilydata.xls");
	  
	  FileInputStream finput=new FileInputStream(src);
	  workbook=new HSSFWorkbook(finput);
	  sheet=workbook.getSheetAt(0);
	  for(int i=1; i<=sheet.getLastRowNum();i++) {
		  cell=sheet.getRow(i).getCell(1);
		  cell.setCellType(Cell.CELL_TYPE_STRING);
		  driver.findElement(By.name("admin_name")).clear();
		  driver.findElement(By.name("admin_name")).sendKeys(cell.getStringCellValue());
		  cell=sheet.getRow(i).getCell(2);
		  cell.setCellType(Cell.CELL_TYPE_STRING);
		  driver.findElement(By.name("admin_password")).clear();
		  driver.findElement(By.name("admin_password")).sendKeys(cell.getStringCellValue());
	  }
	 
	  Thread.sleep(1000);
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='admin_login_form']//input[@class='login_btn blue_lgel']")));
	  button.click();
	  Thread.sleep(1000);
       String expectedErrorMsg="�\n" + 
   	  		"Error\n" + 
   	  		"Invalid Login Details";
       String actualErrorMsg=driver.findElement(By.className("default")).getText();
       Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
       System.out.println("ok bro"+driver.getCurrentUrl());
       Thread.sleep(1000);
	  
	  
	  
  }

  @DataProvider(name="cabilyData")
  public Object[][] passData() {
	  Object[][] data=new Object[3][2];
	  //invlaid username and password
	  data[0][0]="admindem";
	  data[0][1]="admindemo#";
	  //valid username and invlaid password
	  data[1][0]="admidemo";
	  data[1][1]="admin@demo";
	  //valid password  and invalid username
	  data[2][0]="admindem";
	  data[2][1]="admindemo@";
	  return data;
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", Driverpath);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	  
	  
  }

  @AfterTest
  public void afterTest() 
  {
	 driver.quit();
	  
	  
  }

}
