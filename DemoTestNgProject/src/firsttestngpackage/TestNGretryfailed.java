package firsttestngpackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGretryfailed {


	@Test
	public void test1() {		
	System.out.println("iam inside in test1");
		
	}
	@Test
	public void test2() {
		System.out.println("iam inside in test2");
		//int i=1/0;
		
	}
	
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void test3() {
		System.out.println("iam inside in test3");
		AssertJUnit.assertTrue(0>1);
		
	}
}
