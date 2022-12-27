package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PetServices {
	public WebDriver driver;
	public String baseUrl="http://192.168.1.38:3000";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
  @Test
  public void f() throws Exception{
	  driver.findElement(By.xpath("//input[@name='name']")).sendKeys("admin");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
	  Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/a[4]")).click();
	  Thread.sleep(1000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/button[2]/span[1]/*")).click();
   Thread.sleep(2000);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", Driverpath);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }
  
  

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
