


package com.inetbankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankingV1.pageObjects.AddCustomerPage;
import com.inetbankingV1.pageObjects.LoginPage;

public class TC_Addcustomer_003 extends BaseClass {
	@Test
	public void addnewcustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setUserPassword(password);
		logger.info("password entered");
		lp.Clicksubmit();
		logger.info(" entered submit");
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
           Thread.sleep(4000);

		
		logger.info(" dashborad entered");
		
		addcust.ClickNewCustomer();
		//addcust.waitForAlert(driver);
		addcust.EnterCusName("gokul");
		addcust.ClickGenderBtn();
		addcust.dateOfBirth("10","4","1997");
		Thread.sleep(3000);
		addcust.EnterAddress("no address");
		addcust.EnterCity("CHENNAI");
		addcust.EnterState("TN");
		addcust.EnterPincode(600042);
		addcust.EnterPHnum(999999999);
		String email=randomstring()+"@gmail.com";
		addcust.Enteremail(email);
		addcust.Enterpassword("abcdef@123");
		addcust.clicksubmit();
		logger.info("form  entered clicked submit");
		
		Thread.sleep(3000);
	boolean validation=	driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (validation==true){
			Assert.assertTrue(true)
			;
			logger.info("test passed");
		}else {captureScreenshot(driver,"addnewcustomer");
			Assert.assertTrue(false);
			logger.info("failed screenshot taken entered");
		}
	}

}
