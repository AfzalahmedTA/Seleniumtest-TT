package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewCabilyTestNG {
	public String baseUrl="https://ecabily-testing.zoplay.com/v1.0/";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver;
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(1000); 
	String ran=("Testing"+randomInt+"@gmail.com");
	String name="Cabily";
	String lname="test";
	String refcode="AFSAL15";
	String card="Testcabily";
	String cardno="378282246310005";
	String cvv="123";
	String zip="12345";
	 String promo="E0MIPY1HUB";
	
  @Test(priority=0)
  public void login()throws Exception {
	  System.out.println("Login pages opens");
	  driver.findElement(By.xpath("//a[@class='right_actives']")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Login/Register as Rider')]")).click();
	  WebElement dwd=driver.findElement(By.id("country_code"));
	  Select sel=new Select(dwd);
	  sel.selectByIndex(100);
	  int num1, num2, num3;
		 int set3, set4; 
		 Random generator = new Random();
		 num1 = generator.nextInt(6) +2; 
		  num2 = generator.nextInt(8);
		 num3 = generator.nextInt(8);
		 set3 = generator.nextInt(643) + 100;
		 set4 = generator.nextInt(8999) + 1000;
		 String Key=("(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set3 + "-" + set4 );
	  driver.findElement(By.id("mobile_number")).sendKeys(Key);
	  driver.findElement(By.xpath("//input[@id='otp_send_btn']")).click();
	  Thread.sleep(2000);
	  String data=driver.findElement(By.xpath("//span[@id='temp_otp']")).getText();
	  String regex = "([0-9]+)";
	  Pattern pattern = Pattern.compile(regex);
	  Matcher matcher = pattern.matcher(data);
	  while(matcher.find()) {
	  driver.findElement(By.xpath("//input[@id='mobile_otp']")).sendKeys(matcher.group());
	  }
	  driver.findElement(By.xpath("//input[@class='verify_btn otp_btn']")).click(); 
  }
  @Test(priority=1)
  public void registerPage() throws Exception {
	  System.out.println("The Register page");
	  driver.findElement(By.id("email")).sendKeys(ran);
	 Thread.sleep(1000);
	  driver.findElement(By.id("user_name")).sendKeys(name);
	  Thread.sleep(1000);
	  driver.findElement(By.id("last_name")).sendKeys(lname);
	  Thread.sleep(1000);
	  driver.findElement(By.id("referal_code")).sendKeys(refcode);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@class='acc_creat securityCheck']")).click();
	  Thread.sleep(2000);
	  String toast1=driver.findElement(By.className("default")).getText();
	  System.out.println("The Toast box"+toast1);
	  Thread.sleep(1000);
	  WebElement loc=driver.findElement(By.xpath("//select[@name='location_id']"));
	  Select sel1=new Select(loc);
	  sel1.selectByIndex(1);
	  driver.findElement(By.xpath("//button[@id='Submit_button']")).click();
  }
  @Test(priority=2)
  public void addPhoto()throws Exception {
	  System.out.println("The photo");
	  StringSelection sel3 = new StringSelection("D:\\Afsal\\bike.jpg");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel3,null);
		 driver.findElement(By.xpath("//button[@class='wh_btn prv_btn']")).click();
		 Robot bot = new Robot();
		 Thread.sleep(1000);
		  bot.keyPress(KeyEvent.VK_ENTER);
		  bot.keyRelease(KeyEvent.VK_ENTER);
		  bot.keyPress(KeyEvent.VK_CONTROL);
		  bot.keyPress(KeyEvent.VK_V);
		  bot.keyRelease(KeyEvent.VK_CONTROL);
		  bot.keyRelease(KeyEvent.VK_V);
		  Thread.sleep(1000);
		  bot.keyPress(KeyEvent.VK_ENTER);
		  bot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@class='rd_btn add_money_btn profile_sbmt_btn']")).click();
		  Thread.sleep(2000);
  }
  @Test(priority=3)
  public void modules()throws Exception  {
	  System.out.println("The moduled");
	  driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Payments')]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@class='ad-mthd']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='card_holder_name']")).sendKeys(card);
	  driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys(cardno);
	  WebElement exp=driver.findElement(By.id("card_month"));
	  Select mon=new Select(exp);
	  mon.selectByIndex(5);
	  Thread.sleep(1000);
	  WebElement exp1=driver.findElement(By.id("card_year"));
	  Select year=new Select(exp1);
	  year.selectByIndex(18);
	  driver.findElement(By.xpath("//input[@id='card_cvv']")).sendKeys(cvv);
	  driver.findElement(By.xpath("//input[@id='zip_code']")).sendKeys(zip);
	  driver.findElement(By.xpath("//button[@id='continue-btn1']")).click();
	  Thread.sleep(4000);
  }
  @Test(priority=4)
  public void modules1() throws Exception  {
	  System.out.println("The moduled1");
	  
	   driver.findElement(By.linkText("Book Ride")).click();
		Thread.sleep(1000);
		WebElement from=driver.findElement(By.id("pickup_location"));
		from.clear();
		from.sendKeys("Greams Road");
		Thread.sleep(1000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement to=driver.findElement(By.id("drop_location"));
		to.clear();
		to.sendKeys("Chennai");
		Thread.sleep(1000);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement ride=driver.findElement(By.id("type"));
		Select dp=new Select(ride);
		dp.selectByIndex(1);
		Thread.sleep(1000);
		WebElement pay=driver.findElement(By.id("payment_type"));
		Select dp1=new Select(pay);
		dp1.selectByIndex(3);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='use-btn']")).click();
		Thread.sleep(2000);
		WebElement caa=driver.findElement(By.id("category"));
		Select dp2=new Select(caa);
		dp2.selectByIndex(2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys(promo);
		driver.findElement(By.xpath("//p[@id='apply_promo_box']//span//input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='booking']")).click();
		Thread.sleep(1000); 
  }
  
 @Test(priority=5) 
 public  void modules2() throws Exception{
	 System.out.println("The moduled2");
	 driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Rate Card')]")).click();
	 Thread.sleep(1000);
	 WebElement rate=driver.findElement(By.xpath("//select[@id='city_rate_card']"));
	 Select cad=new Select(rate);
	 cad.selectByIndex(1);
	 Thread.sleep(1000);
	 WebElement type=driver.findElement(By.xpath("//select[@id='cat_rate_card']"));
	 Select car=new Select(type);
	 car.selectByIndex(2);
	 Thread.sleep(1000);
	 JavascriptExecutor js = (JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,250)");
	 Thread.sleep(2000);
 }
 @Test(priority=6)
 public void modules3()throws Exception {
	 System.out.println("The moduled3");
	 driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Cabily Money')]")).click();
	 Thread.sleep(1000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,300)");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//label[@id='money_bucket1']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[@id='payBtn']")).click();
	 Thread.sleep(4000);
	 driver.findElement(By.xpath("//button[@class='use-btn']")).click();
	 Thread.sleep(2000);
	 String toast2=driver.findElement(By.className("default")).getText();
	 System.out.println("The Toast box"+toast2);
	 Thread.sleep(3000);
	driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[2]/div[3]/div[1]/a[1]")).click();
	 Thread.sleep(2000);
	 
 }
 @Test(priority=7)
 public void modules4()throws Exception {
	 System.out.println("The moduled4");
	 driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Share & Earnings')]")).click();
	 Thread.sleep(1000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,150)");
	 Thread.sleep(1000);
	 String ref=driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[2]/div[3]/p[4]")).getText();
	 System.out.println("The refreal code"+ref);
	 Thread.sleep(2000);	
 }
 @Test(priority=8)
public void modules5() throws Exception {
	 System.out.println("The modules5");
	 driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Favorite Locations')]")).click();
	 Thread.sleep(2000);
	 
 }
 @Test(priority=9)
 public void logout() {
	 System.out.println("The logout");
	 driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Logout')]")).click();
	 String log=driver.findElement(By.className("default")).getText();
	 System.out.println("success "+log);
	 
 }
 
  @BeforeTest
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", Driverpath);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.get(baseUrl);

  }

  @AfterTest
  public void closeBrowser() throws Exception{
	  System.out.println("The close");
	  Thread.sleep(2000);
driver.close();
  }

}
