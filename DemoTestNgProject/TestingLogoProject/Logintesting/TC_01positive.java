package Logintesting;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC_01positive {
	public WebDriver driver;
	public String baseUrl = "http://192.168.1.16/phpmongo/admin";
	String Driverpath = "C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	JavascriptExecutor js = (JavascriptExecutor) driver;
  @Test
  public void Testcase() throws Exception{
	  driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("saravanan.r@casperon.in");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
		Thread.sleep(1000);
		String Expected="Home - PHP MongoDB";
		String Actual=driver.getTitle();
		Assert.assertEquals(Actual, Expected);
		System.out.println(Actual);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='frm-submit']")));
		login.click();
	WebElement toast=driver.findElement(By. cssSelector("body:nth-child(2) div:nth-child(4) div.main-content > script:nth-child(43)")); 
	String Message= (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", toast);
		System.out.println("The"+Message);
		
	  
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
