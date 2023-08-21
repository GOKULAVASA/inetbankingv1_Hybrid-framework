package com.inetbankingV1.testCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankingV1.pageObjects.AddCustomerPage;
import com.inetbankingV1.pageObjects.RetrivingSuccesfullCust;
import com.inetbankingV1.testutilities.databseUtils;

public class TC_RetrivingSucessfullCustDetailsTest_004 extends TC_Addcustomer_003{
	@Test
	public void TC_RetrivingSucessfullCustDetailsTest_004() throws IOException, InterruptedException, SQLException {

		AddCustomerPage addcust=new AddCustomerPage(driver);
		logger.info(" dashborad entered");

		addcust.ClickNewCustomer();
		logger.info("new customer clicked ");
		Thread.sleep(5000);
		//	driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		//driver.switchTo().frame("ad_iframe");

		//	driver.findElement(By.id("dismiss-button")).click();
		//	driver.switchTo().defaultContent();

		//	logger.info("handled");
		addcust.EnterCusName("gkvasan");
		addcust.ClickGenderBtn();
		addcust.dateOfBirth("10","9","1997");
		Thread.sleep(3000);
		addcust.EnterAddress("heaven is my  address");
		addcust.EnterCity("CHENNAI");
		addcust.EnterState("TN");
		addcust.EnterPincode(600042);
		addcust.EnterPHnum(777777777);
		String email=randomstring()+"@gmail.com";
		addcust.Enteremail(email);
		addcust.Enterpassword("abcdef@123");
		addcust.clicksubmit();
		logger.info("form  entered clicked submit");
		if (isAlertPresent()==true) {

			logger.info("failed to create exception handled");
			driver.switchTo().defaultContent();
		}
		Thread.sleep(3000);
		boolean validation=	driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (validation==true){
			Assert.assertTrue(true);

			logger.info("test passed");
		}else {captureScreenshot(driver,"addnewcustomer");
		Assert.assertTrue(false);
		logger.info("failed screenshot taken entered");
		}
	




		RetrivingSuccesfullCust retrivcust=new RetrivingSuccesfullCust(driver);

		String custmoerID=retrivcust.GetCustId();
		String customername=retrivcust.getCustName();
		String gender=retrivcust.GetCustGender();
		String custDOB=retrivcust.GetCustDoB();
		String custADDRESS=retrivcust.GetCustAddress();
		String custCITY=retrivcust.GetCustCity();
		String custSTATE=retrivcust.GetCustState();
		String custPINCODW=retrivcust.GetCustPINCODE();
		String custNUM=retrivcust.GetCustMobileNum();
		String custEMAIL=retrivcust.GetCustEmail();

		databseUtils util=new databseUtils();
		databseUtils.openConnection();
		databseUtils.createTable();
		databseUtils.insertCustomerDetails("custid", custmoerID);
		databseUtils.insertCustomerDetails("custName", customername);
		databseUtils.insertCustomerDetails("custgender", gender);
		databseUtils.insertCustomerDetails("custDOB", custDOB);
		databseUtils.insertCustomerDetails("custPOA", custADDRESS);
		databseUtils.insertCustomerDetails("custcity", custCITY);
		databseUtils.insertCustomerDetails("custstate", custSTATE);
		databseUtils.insertCustomerDetails("custpodtalCode", custPINCODW);
		databseUtils.insertCustomerDetails("custnumber", custNUM);
		databseUtils.insertCustomerDetails("custmail", custEMAIL);

		}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert().dismiss();
			logger.warn("yes alret is there ");
			return true;
		}catch(NoAlertPresentException e)
		{	logger.info("exception handled ");
		return false;



	}

	}
}










