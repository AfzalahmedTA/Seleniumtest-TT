package Facebook.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert {
	public static WebDriver driver;
	public static void main(String[] args) {
		
		try {
			WebDriverManager.chromedriver().setup();
			 driver =new ChromeDriver();
			  driver.get("https://demo.automationtesting.in/Register.html");
			  driver.manage().window().maximize();
			  Thread.sleep(6000);
			   alert1("//button[contains(text(),'click the button to display an  alert box:')]");
//			  driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]")).click();
//			  driver.switchTo().alert().sendKeys("");
//			  driver.switchTo().alert().accept();
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
	}
	public static void alert1(String element) {
		 Boolean check= driver.findElement(By.xpath(element)).isSelected();
		 if(check.equals(false)) {
			 driver.findElement(By.xpath(element)).click();
		 }
		
	}

}
