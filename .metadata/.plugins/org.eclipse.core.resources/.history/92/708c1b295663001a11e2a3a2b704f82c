package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Singup2cabily {
	public WebDriver driver;
	public String baseUrl="https://cabily-e.zoplay.com/rider/signup?data=KzkxJiY4ODI1NjQ0MDE2&";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	String mail="Testing@gmail.com";
  @Test
  public void EmailNegative() throws Exception{
	  String spclChar= "@,(,):;',<>.,{}[]";
	     String vin = "";
	     Random random = new Random();
	     for (int i = 0; i < 4; i++) {
	         char c = spclChar.charAt(random.nextInt(spclChar.length()));
	         vin+=c;
	     }
	  driver.findElement(By.name("email")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("email")).sendKeys(vin+mail);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']")).click();
	  String expectedErrorMsg="Please enter a valid email address.";
	  WebElement exp=driver.findElement(By.xpath("//label[contains(text(),'Please enter a valid email address.')]"));
	  String actualErrorMsg=exp.getText();
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  screenCapture();
	  System.out.println("ok tested");
	  Thread.sleep(1000);
  }
  @Test
  public void EmailNegative1() throws Exception{
	  driver.findElement(By.name("email")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.name("email")).sendKeys("");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']")).click();
	  String expectedErrorMsg="This field is required.";
	  WebElement exp=driver.findElement(By.xpath("//div[@class='col-md-8 col-lg-8 register_form_detail']//div[2]//label[1]"));
	  String actualErrorMsg=exp.getText();
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  screenCapture();
	  System.out.println("ok ");
	  Thread.sleep(2000); 
  }
  @Test
  public void EmailNegative2() throws Exception{
	  driver.findElement(By.name("email")).clear();
	  Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("ahmed@casperon.in");
	  Thread.sleep(2000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-150)");
		 Thread.sleep(4000);
	  driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']")).click();
	  String expectedErrorMsg="ahmed@casperon.in already exist";
	  WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement mailbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailErr")));
	  String actualErrorMsg=mailbox.getText();
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  screenCapture();
	  System.out.println("ok bro");
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
  public void screenCapture() throws IOException{
		 File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File screenshotName=new File ("D:\\slm\\DemoTestNgProject\\screenshots\\"+"email.png");
		  FileUtils.copyFile(SrcFile, screenshotName);
		  Reporter.log("<br><img src='"+screenshotName+"'height='300' width='300'/><br>");	
		
		
	}

  @AfterTest
  public void afterTest()throws Exception {
	  Thread.sleep(1000);
	  driver.close();
  }

}
