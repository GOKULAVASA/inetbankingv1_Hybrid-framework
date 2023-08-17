

package com.inetbankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("url launched");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username  entered");
		lp.setUserPassword(password);
		logger.info("password entered");
		lp.Clicksubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("title matched");
		}
		else {captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("title is not matched");
		}
	}
	
	
	
}