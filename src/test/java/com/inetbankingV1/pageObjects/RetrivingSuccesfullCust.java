package com.inetbankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RetrivingSuccesfullCust {
public WebDriver driver;


public RetrivingSuccesfullCust(WebDriver d){
	driver=d;
	PageFactory.initElements(d,this);
}

	


@FindBy(how=How.XPATH,using="//td[text()='Customer ID']/following-sibling::td")
WebElement custId;


@FindBy(xpath="//td[text()='Customer Name']/following-sibling::td")
WebElement custName;

@FindBy(xpath="//td[text()='Gender']/following-sibling::td")
WebElement custGender;

@FindBy(xpath="//td[text()='Birthdate']/following-sibling::td")
WebElement custDOB;

@FindBy(xpath="//td[text()='Address']/following-sibling::td")
WebElement custCommunicationAddress;

@FindBy(xpath="//td[text()='City']/following-sibling::td")
WebElement custLivingCity;


@FindBy(xpath="//td[text()='State']/following-sibling::td")
WebElement custStateOfLiving;


@FindBy(xpath="//td[text()='Pin']/following-sibling::td")
WebElement custPINcode;


@FindBy(xpath="//td[text()='Mobile No.']/following-sibling::td")
WebElement custContactNum;

@FindBy(xpath="//td[text()='Email']/following-sibling::td")
WebElement custEmail;




public String GetCustId() {
	
	return custId.getText();
	
}


public String getCustName() {
    return custName.getText();
}


public String GetCustGender() {
	
	return custGender.getText();
}


public String GetCustDoB() {
	
	return custDOB.getText();
}


public String GetCustAddress() {
	
	return custCommunicationAddress.getText();
}


public String GetCustCity() {
	return custLivingCity.getText();
	
}

public String GetCustState() {
	
	return custStateOfLiving.getText();
}


public String GetCustPINCODE() {
	return custPINcode.getText();
	
}

public String GetCustMobileNum() {
	return custContactNum.getText();
	
}

public String GetCustEmail() {
	
	return custEmail.getText();
}
}
