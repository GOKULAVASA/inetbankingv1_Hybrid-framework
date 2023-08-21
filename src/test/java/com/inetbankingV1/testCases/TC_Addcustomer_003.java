


package com.inetbankingV1.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.inetbankingV1.pageObjects.AddCustomerPage;
import com.inetbankingV1.pageObjects.LoginPage;
import com.inetbankingV1.pageObjects.RetrivingSuccesfullCust;

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


		logger.info(" dashborad entered");

		addcust.ClickNewCustomer();
		logger.info("new customer clicked ");
		Thread.sleep(5000);
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.switchTo().frame("ad_iframe");

		driver.findElement(By.id("dismiss-button")).click();
		driver.switchTo().defaultContent();

		logger.info("handled");
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
		if (isAlertPresent()==true) {

			logger.info("failed to create exception handled");
			driver.switchTo().defaultContent();
		}
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


	{
	}
}