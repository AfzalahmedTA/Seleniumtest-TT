package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Singup4cabily {
	public WebDriver driver;
	public String baseUrl="https://cabily-e.zoplay.com/rider/signup?data=KzkxJiY4ODI1NjQ0MDE2&";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
  @Test
  public void referralcodeNegative() throws Exception{
	  driver.findElement(By.name("email")).clear();
		 Thread.sleep(1000);
		 WebElement Eemail=driver.findElement(By.name("email"));
		  Eemail.sendKeys("afsal@gmail.com");
		  Thread.sleep(1000);
		  driver.findElement(By.name("user_name")).clear();
		  Thread.sleep(1000);
		  WebElement fname=driver.findElement(By.name("user_name"));
		  fname.sendKeys("Afsal");
		  Thread.sleep(1000);
		  driver.findElement(By.name("last_name")).clear();
		  Thread.sleep(1000);
		WebElement lname=driver.findElement(By.name("last_name")) ;
		lname.sendKeys("Ahmed");
		Thread.sleep(1000);
		 driver.findElement(By.name("referal_code")).clear();
		 Thread.sleep(1000);
		WebElement refcode=driver.findElement(By.name("referal_code"));
		refcode.sendKeys("ASKDG_2387");
		 Thread.sleep(1000);
		WebElement cacc=driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']"));
		cacc.click();
		Thread.sleep(3000);
		 String expectedErrorMsg="SORRY,YOU HAVE APPLIED INVALID REFERRAL CODE";
		 WebElement exp=driver.findElement(By.xpath("//p[@id='invalid_code']"));
		 String actualErrorMsg=exp.getText();
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		 screenCapture();
		 System.out.println("ok 3");
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
	  driver.manage().timeouts().implicitlyWait(25 , TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	  
  }
public void screenCapture() throws IOException{
	 File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File screenshotName=new File ("D:\\slm\\DemoTestNgProject\\screenshots\\"+"referralcode.png");
	  FileUtils.copyFile(SrcFile, screenshotName);
	  Reporter.log("<br><img src='"+screenshotName+"'height='300' width='300'/><br>");	
	
	
}
  
  
  
  @AfterTest
  public void afterTest() throws Exception{
Thread.sleep(1000);
  driver.close();
}
  }


