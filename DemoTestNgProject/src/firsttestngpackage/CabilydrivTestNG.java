package firsttestngpackage;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;	



public class CabilydrivTestNG {
	public String baseUrl="https://cabily-e.zoplay.com/driver/signup";
	String Driverpath="C:\\Users\\user65\\Downloads\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver;
	String mail="ahmed@casperon.in";
	String mail1="afsalahmed@casperon.in";
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(1000); 
	String ran=("Testcabily"+randomInt+"@gmail.com");
	
	
	
  @Test(priority=0)
  public void login()throws Exception {
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
	  Thread.sleep(1000);	
	  driver.findElement(By.xpath("//input[@id='otp_send_btn']")).click();
	  Thread.sleep(3000);
	  String data=driver.findElement(By.xpath("//span[@id='temp_otp']")).getText();
	  Thread.sleep(2000);
	  String regex = "([0-9]+)";
	  Pattern pattern = Pattern.compile(regex);
	  Matcher matcher = pattern.matcher(data);
	  while(matcher.find()) {
		  Thread.sleep(1000);
	       driver.findElement(By.xpath("//input[@id='mobile_otp']")).sendKeys(matcher.group());
	
	  }
		 
	  Thread.sleep(1000);
	  WebDriverWait wait = new WebDriverWait(driver,20);
	  	WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='verify_btn otp_btn']")));
	  submit.click();
	  screenCapture();
	  Thread.sleep(2000);
  }
  @Test(priority=1)
  public void register()throws Exception {
	  WebElement city=driver.findElement(By.id("driver_location"));
		 Select ct=new Select(city);
		 ct.selectByIndex(5);
		 String alphabet= "abcdefghijklmnopqrstuvwxyz";
	     String s = "";
	     Random random = new Random();
	     for (int i = 0; i < 5; i++) {
	         char c = alphabet.charAt(random.nextInt(alphabet.length()));
	         s+=c;
	     }
		 driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(s);
		  
		  driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Cabily");
		  
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(ran);
		  WebElement gender=driver.findElement(By.xpath("//select[@id='gender']"));
		  Select gen=new Select(gender);
		  gen.selectByIndex(1);
		  driver.findElement(By.xpath("//input[@id='dob-date']")).click();
		  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/thead[1]/tr[1]/th[2]")).click();
		  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/table[1]/thead[1]/tr[1]/th[2]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'1995')]")).click();
		  driver.findElement(By.xpath("//div[1]//div[4]//span[7]")).click();
		  driver.findElement(By.xpath("//div[1]//tr[3]//td[7]")).click();
		  Thread.sleep(1000); 
  }
  @Test(priority=2)
  public void register1() throws Exception{
	  driver.findElement(By.xpath("//input[@id='address']")).sendKeys("No:25 abc street Abc nagar");
	  Select drop=new Select(driver.findElement(By.id("county")));
	  drop.selectByVisibleText("India");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Tamilnadu");
	  driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Chennai");
	  driver.findElement(By.xpath("//input[@id='postal_code']")).sendKeys("600001");
Thread.sleep(1000);
WebElement im=driver.findElement(By.id("thumbnail"));
	  im.sendKeys("D:\\Afsal\\iot.jpg");
Thread.sleep(1000);
	  WebElement vehim=driver.findElement(By.id("vehicle_image"));
vehim.sendKeys("D:\\Afsal\\bike.jpg");
Thread.sleep(2000);  
  }
  @Test(priority=3)
  public void register2()throws Exception {
	  String number= "12345678905658";
	     String vin = "";
	     Random random = new Random();
	     for (int i = 0; i < 10; i++) {
	         char c = number.charAt(random.nextInt(number.length()));
	         vin+=c;
	     }
	     String bikeno= "0123456789";
	       String bikeno1 = "123456789";
	        String no = "TN 0";
	       
	        for (int j=0 ; j< 1 ; j++)
	        {
	            char c = bikeno1.charAt(random.nextInt(bikeno1.length()));
	            no = no+c;
	        }
	        no = no + " AB ";
	        for (int i = 0; i < 4; i++) {
	            char c = bikeno.charAt(random.nextInt(bikeno.length()));
	            no+=c;
	        }
	     Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='vin_number']")).sendKeys(vin);
	  driver.findElement(By.xpath("//input[@id='vehicle_number']")).sendKeys(no);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='vehicle_type']")).clear();
	  driver.findElement(By.xpath("//input[@id='vehicle_type']")).sendKeys("SUV");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='vehicle_maker']")).clear();
	  driver.findElement(By.xpath("//input[@id='vehicle_maker']")).sendKeys("Mercendz benz");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='vehicle_model']")).clear();
	  driver.findElement(By.xpath("//input[@id='vehicle_model']")).sendKeys("E230");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='vehicle_model_year']")).clear();
	  driver.findElement(By.xpath("//input[@id='vehicle_model_year']")).sendKeys("2018");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='no_of_door']")).clear();
	  driver.findElement(By.xpath("//input[@id='no_of_door']")).sendKeys("4");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='no_of_seat_belt']")).clear();
	  driver.findElement(By.xpath("//input[@id='no_of_seat_belt']")).sendKeys("5");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@id='vehicle_color']")).clear();
	  driver.findElement(By.xpath("//input[@id='vehicle_color']")).sendKeys("black");
	  Thread.sleep(9000);
  }  
  @Test(priority=4)
  public void register3() throws Exception{
	  StringSelection license = new StringSelection("D:\\Afsal\\iot.jpg");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(license,null);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//label[@id='docx-5bdacb556803fa4e14e4129a-lbl']")).click();
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
	  Thread.sleep(9000);
	  driver.findElement(By.xpath("//label[@id='docx-5d440f314c7f336e57124b82-lbl']")).click();
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
	  Thread.sleep(9000);
	  driver.findElement(By.id("expiry-docx-5bdacb556803fa4e14e4129a")).click();
	  driver.findElement(By.xpath("//div[2]//div[3]//tr[1]//th[2]")).click();
	  driver.findElement(By.xpath("//div[2]//div[4]//th[2]")).click();
	  driver.findElement(By.xpath("//div[2]//div[5]//span[6]")).click();
	  driver.findElement(By.xpath("//div[2]//div[4]//span[7]")).click();
	  driver.findElement(By.xpath("//div[2]//tr[3]//td[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("expiry-docx-5d440f314c7f336e57124b82")).click();
	driver.findElement(By.xpath("//body//div[3]//div[3]//tr[1]//th[2]")).click();
	driver.findElement(By.xpath("//div[3]//div[4]//th[2]")).click();
	driver.findElement(By.xpath("//div[3]//div[5]//span[7]")).click();
	driver.findElement(By.xpath("//div[3]//div[4]//span[8]")).click();
	driver.findElement(By.xpath("//body//div[3]//div[3]//tr[4]//td[4]")).click();
	Thread.sleep(9000);
  }
  @Test(priority=5)
  public void register4()throws Exception {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,200)");
		 Thread.sleep(2000);
	  StringSelection registration  = new StringSelection("D:\\Afsal\\iot.png");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(registration,null);
		 driver.findElement(By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[19]/li[1]/label[1]")).click();
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
		  Thread.sleep(8000);
		  driver.findElement(By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[20]/li[1]/label[1]")).click();
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
 	  Thread.sleep(8000);
  }
  @Test(priority=6)
  public void register5()throws Exception {
	  driver.findElement(By.id("expiry-docx-5bdacbb46803fa9c14e41298")).click();
  	driver.findElement(By.xpath("//div[4]//div[3]//tr[1]//th[2]")).click();
  	driver.findElement(By.xpath("//body//div[4]//div[4]//th[2]")).click();
  	driver.findElement(By.xpath("//div[4]//div[5]//span[6]")).click();
  	driver.findElement(By.xpath("//body//div[4]//div[4]//span[7]")).click();
  	driver.findElement(By.xpath("//div[4]//tr[3]//td[2]")).click();
  	Thread.sleep(2000);
  	driver.findElement(By.id("expiry-docx-5d440f5e4c7f336ea6789552")).click();
  	driver.findElement(By.xpath("//div[5]//div[3]//tr[1]//th[2]")).click();
  	driver.findElement(By.xpath("//div[5]//div[4]//th[2]")).click();
  	driver.findElement(By.xpath("//body//div[5]//div[5]//span[3]")).click();
  	driver.findElement(By.xpath("//div[5]//div[4]//span[6]")).click();
  	driver.findElement(By.xpath("//div[5]//tr[3]//td[3]")).click();
  	Thread.sleep(2000);
  	JavascriptExecutor js = (JavascriptExecutor) driver;
  	js.executeScript("window.scrollBy(0,150)");
  	Thread.sleep(1000);
  	WebElement inspection=driver.findElement(By.id("boarding_id"));
  	Select ins=new Select(inspection);
  	ins.selectByIndex(1);
  	Thread.sleep(2000);
  	driver.findElement(By.id("appointment_date")).click();
  	driver.findElement(By.xpath("//div[6]//tr[3]//td[3]")).click();
  	driver.findElement(By.xpath("//div[6]//div[2]//span[10]")).click();
  	driver.findElement(By.xpath("//span[contains(text(),'9:35')]")).click();
  	Thread.sleep(2000);
  	 WebDriverWait wait = new WebDriverWait(driver,20);
  	WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col docu_sub']//input[2]")));
  	button.click();
  	screenCapture();
  	Thread.sleep(5000);
  }
  @Test(priority=7)
  public void cabily()throws Exception {
	  driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Profile')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Change Email')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Change Mobile")).click();
		screenCapture();
		Thread.sleep(2000);
  }
  @Test(priority=8)
  public void cabily1() throws Exception{
	  driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Banking')]")).click();
		Thread.sleep(1000);
		WebElement wt =driver.findElement(By.id("withdrawal_type"));
		Select sel1=new Select(wt);
		sel1.selectByIndex(1);
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='__privateStripeFrame5']")));
		driver.findElement(By.name("cardnumber")).sendKeys("4000056655665556");
		driver.findElement(By.name("exp-date")).sendKeys("1023");
		driver.findElement(By.name("cvc")).sendKeys("123");
		driver.findElement(By.name("postal")).sendKeys("12345");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='cont-btn']")).click();
		screenCapture();
		Thread.sleep(4000); 
  }
  @Test(priority=9)
  public void cabily2() throws Exception{
	  driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Rides')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Earnings')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Manage Vehicles')]")).click();
		screenCapture();
		Thread.sleep(2000);
	  
  }
  @Test(priority=10)
  public void cabily3()throws Exception {
	  driver.findElement(By.xpath("//a[@id='addBtn']")).click();
		Thread.sleep(2000);
		WebElement cat=driver.findElement(By.id("category"));
		Select sel=new Select(cat);
		sel.selectByIndex(4);
		Thread.sleep(1000);
      driver.findElement(By.id("vin_number")).sendKeys("15645588265");
      driver.findElement(By.id("vehicle_number")).sendKeys("TN09A3222"); 
      driver.findElement(By.id("vehicle_type")).sendKeys("SUV");
      driver.findElement(By.id("vehicle_maker")).sendKeys("Audi");
      driver.findElement(By.id("vehicle_model")).sendKeys("Q3");
      driver.findElement(By.id("vehicle_model_year")).sendKeys("2016");
      driver.findElement(By.id("vehicle_color")).sendKeys("white");
      driver.findElement(By.id("no_of_door")).sendKeys("4");
      driver.findElement(By.id("no_of_seat_belt")).sendKeys("5");
		WebElement chos=driver.findElement(By.id("vehicle_image"));
		chos.sendKeys("D:\\Afsal\\bike.jpg");
		Thread.sleep(2000);
		WebElement chos1=driver.findElement(By.id("docx-5bdacbb46803fa9c14e41298"));
		chos1.sendKeys("D:\\Afsal\\bike.jpg");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(1000);
  }
		@Test(priority=11)
		public void cabily4()throws Exception {
		driver.findElement(By.id("expiry-docx-5bdacbb46803fa9c14e41298")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/thead[1]/tr[1]/th[2]")).click();
		driver.findElement(By.xpath("//div[1]//div[4]//th[2]")).click();
		driver.findElement(By.xpath("//div[1]//div[5]//span[3]")).click();
		driver.findElement(By.xpath("//div[1]//div[4]//span[7]")).click();
		driver.findElement(By.xpath("//div[1]//tr[3]//td[5]")).click();
		Thread.sleep(2000);
		WebElement chos2=driver.findElement(By.id("docx-5d440f5e4c7f336ea6789552"));
	    chos2.sendKeys("D:\\Afsal\\bike.jpg");
	    Thread.sleep(1000);
	    driver.findElement(By.id("expiry-docx-5d440f5e4c7f336ea6789552")).click();
	    driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/table[1]/thead[1]/tr[1]/th[2]")).click();
	    driver.findElement(By.xpath("//div[2]//div[4]//th[2]")).click();
	    driver.findElement(By.xpath("//div[2]//div[5]//span[3]")).click();
	    driver.findElement(By.xpath("//div[2]//div[4]//span[7]")).click();
	    driver.findElement(By.xpath("//div[2]//tr[3]//td[4]")).click();
	    Thread.sleep(1000);
	    WebElement chos3=driver.findElement(By.xpath("//input[@id='boarding_document']"));
	    chos3.sendKeys("D:\\Afsal\\bike.jpg");
        Thread.sleep(2000);   
  }
  @Test(priority=12)
  public void cabily5()throws Exception {
	  WebElement chos4=driver.findElement(By.id("boarding_id"));
	    Select sel2=new Select(chos4);
	    sel2.selectByIndex(0);
	    Thread.sleep(1000);
		driver.findElement(By.id("appointment_date")).click();
    driver.findElement(By.xpath("//body//div[3]//div[3]//tr[3]//td[4]")) .click();
    driver.findElement(By.xpath("//div[3]//div[2]//span[9]")).click();
    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[6]")).click();
    Thread.sleep(1000);
    WebDriverWait wait = new WebDriverWait(driver,20);
  	WebElement saveinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col docu_sub']//li//input")));
	saveinfo.click();
	screenCapture();
		Thread.sleep(2000);  
	  driver.findElement(By.xpath("//div[@class='profile_det']//a[contains(text(),'Logout')]")).click();
		Thread.sleep(1000);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", Driverpath);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  driver.get(baseUrl);
  }
  public void screenCapture()throws IOException {
	  File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File screenshotName=new File ("D:\\slm\\DemoTestNgProject\\screenshots\\"+driver.getTitle()+".png");
	  FileUtils.copyFile(SrcFile, screenshotName);
	  Reporter.log("<br><img src='"+screenshotName+"'height='300' width='300'/><br>");	
}

  @AfterTest
  public void afterTest() throws Exception{
	  screenCapture();
	  Thread.sleep(2000);
	  driver.close();
	  
  }
}
