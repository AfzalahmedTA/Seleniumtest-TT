package firsttestngpackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
        
      int minretryCount=0;
      int maxretryCount=2;
      public boolean retry(ITestResult result) {
    	  
    	  if(minretryCount<=maxretryCount) {
    		  System.out.println("");
    		  System.out.println("");
    		  minretryCount++;
    		  return true;
    		  
    		  
    	  }
    	  
    	  return false;
      }
	
	
}
