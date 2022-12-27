package Facebook.facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
  public static void main(String[] args) {
  
	  try {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver =new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		 
		  Thread.sleep(7000);
		  String Expectedresult1=driver.getTitle();
		  System.out.println(Expectedresult1);
		  
		//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input  --xpath
		  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin"); 
		  //Thread.sleep(5000);
		 // driver.findElement(By.xpath("//input[@name=\"username\"]")).clear();
		  ////input[@placeholder="Password"] --xpath
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		  
		//button[@class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"]  --button xpath
		  driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
		 
		  Thread.sleep(5000);
		  String Actualresult="Dashboard";
		  String Expectedresult2=driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")).getText();
	    if(Actualresult.equals(Expectedresult2)) {
	    	
	    	System.out.println("User entered into homepage");
	    
	    }
	    else {
	    	System.out.println("user not enetred into homepage");
	    	
	    
	    	
	    	
	    }  
	    
	    driver.findElement(By.xpath("//span[text()='Admin']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//label[text()='User Role']//parent::div/following::div[1]/div/div/div")).click();
	  List<WebElement> drop=  driver.findElements(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//following-sibling::div//span"));
		  for(int i=0; i<drop.size();i++) {
			  String id =drop.get(i).getText();
			  if(id.equals("Admin")) {
				  drop.get(i).click();
			  }
			  System.out.println(id);
		  }
		  
		 List<WebElement> DD= driver.findElements(By.xpath("//select[@id='country_code']//option"));
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  } 
}
