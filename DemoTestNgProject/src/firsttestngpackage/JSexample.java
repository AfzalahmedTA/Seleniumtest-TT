package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSexample {
	public WebDriver driver;// https://ecabily-testing.zoplay.com/v1.0/rider/signup?data=KzkxJiY4ODI1NjQ0MDE5&
	public String baseUrl = "http://192.168.1.16/phpmongo/admin";
	String Driverpath = "C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test
	public void JSexecute() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("saravanan.r@casperon.in");
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,3);
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='frm-submit']")));
		login.click();
		 WebElement toast=driver.findElement(By.cssSelector("body:nth-child(2) > script:nth-child(13)"));
	      String message=(String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", toast);
	      System.out.println(message);
		/*String Toast=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body:nth-child(2) > script:nth-child(13)"))).getText();
		if(Toast.contains("Error\n"+
		"Invalid Login Details!")) {
			System.out.println("Login failed"+Toast);
		}else {
			System.out.println("Login passes"+Toast);
		}*/
        // WebElement toast=driver.findElement(By.cssSelector("body:nth-child(2) > script:nth-child(12)"));
        // String message=(String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", toast);
         //System.out.println("the"+message);
		//System.out.println("the"+toast.isDisplayed());
         /*
		 * WebElement toast=driver.findElement(By.
		 * cssSelector("body:nth-child(2) div:nth-child(4) div.main-content > script:nth-child(43)"
		 * )); String Message= (String) ((JavascriptExecutor)
		 * driver).executeScript("return arguments[0].innerHTML;", toast);
		 * System.out.println("The"+Message);
		 */
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", Driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		driver.close();

	}

}
