package Miklaa.miklaaa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class miklaa {
  public static void main(String[] args) {
	  try {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver =new ChromeDriver();
		  driver.get("https://miklaa.quickiz.com/");
		  driver.manage().window().maximize();
		  Thread.sleep(5000);
  
          WebElement Sigin= driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
          Sigin.click();
 
          WebElement Email=driver.findElement(By.xpath("//input[@id='email']"));  //input[@id='email']
          Thread.sleep(2000);
          Email.click();
          Thread.sleep(2000);
          Email.clear();
          Thread.sleep(3000);
          Email.sendKeys("frank@yopmail.com");
          WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
          Thread.sleep(2000);
          password.click();
          Thread.sleep(2000);
          password.clear();
          Thread.sleep(2000);
          password.sendKeys("123456");
          Thread.sleep(4000);
          
        
          WebElement loginbutton=driver.findElement(By.xpath("//button[@id='signin_button']"));//button[@id='signin_button']
          
          loginbutton.click();
          Thread.sleep(6000);
          System.out.println("Singined");

          WebElement listprpty=driver.findElement(By.xpath("//a[contains(text(),'List Property')]"));
          
          listprpty.click();
          Thread.sleep(3500);
          
          WebElement selectcity=driver.findElement(By.xpath("//select[@id='location_id']"));
          
          Select ct=new Select(selectcity);
          
          ct.selectByIndex(5);
          Thread.sleep(3500);
          
          WebElement loc=driver.findElement(By.xpath("//input[@id='address']"));
          loc.click();
          Thread.sleep(2500);
          loc.sendKeys("Anna Nagar, Chennai, Tamil Nadu, India");
          
          Thread.sleep(3500);
          
          WebElement clickbtn=driver.findElement(By.xpath("//button[@id='nextBtn']"));
          
          clickbtn.click();
          Thread.sleep(3500);
          driver.findElement(By.xpath("//button[contains(text(),'Apartment')]")).click();
          Thread.sleep(2500);
          WebElement year=driver.findElement(By.xpath("//select[@id='year_of_contruct']"));
          Select cty=new Select(year);
         
          cty.selectByValue("2016");
          
          Thread.sleep(2500);
          clickbtn.click();
          Thread.sleep(3500);
          driver.findElement(By.xpath("//input[@id='price']")).sendKeys("7500");
          Thread.sleep(2500);
          clickbtn.click();
          Thread.sleep(2500);
          driver.findElement(By.xpath("//label[contains(text(),'Balcony')]")).click();
          Thread.sleep(2500);
          clickbtn.click();
          Thread.sleep(2500);
          driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Give us some more insights about the property (Please enter 30 - 650 letters )");
          Thread.sleep(3500);
          //driver.findElement(By.xpath("//button[@id='saveBtn']")).click();
          clickbtn.click();
          Thread.sleep(4500);
          
          
          WebElement upload_file=driver.findElement(By.xpath("//body/div[1]/section[3]/div[1]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
          upload_file.click();
          upload_file.sendKeys("D:\\Desktop\\Miklaa\\New\\vu-anh-TiVPTYCG_3E-unsplash.jpg");
          Thread.sleep(5500);
          System.out.println("File is Uploaded Successfully");
          //vu-anh-TiVPTYCG_3E-unsplash.jpg
          
          Thread.sleep(7500);
         //driver.findElement(By.xpath("//button[@id='saveBtn']")).click();
          //driver.quit();
 
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
 
  
  
  }
}
