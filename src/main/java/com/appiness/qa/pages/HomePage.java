package com.appiness.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.appiness.qa.base.TestBase;

public class HomePage extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	@FindBy(xpath="//*[@id=\'root\']/div/div/p[1]")
	WebElement HomePageHeader;
	@FindBy(xpath="//*[@id=\'root\']/div/div/p[2]")
	WebElement HomePageEmail;
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	WebElement logoutbutton;
	@FindBy(xpath="//table[@class='chakra-table css-1ner0ss']")
	WebElement table;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void VerifyHomepageHeader()
	{
		
		String homepageheader=HomePageHeader.getText();
	   
	     Assert.assertEquals(homepageheader, "Appiness Employee dashboard");	
	}
	
	public void VerifyEmailInHomepageTest()
	{
	    String user=prop.getProperty("username");
	    String homepageEmail=HomePageEmail.getText();
	    Assert.assertEquals(user, homepageEmail);
	}
	
	public void VerifyTablePresenceTest()
	{
		table.isDisplayed();
	}
	
	public void logoutButtonPresenceTest()
	{
		logoutbutton.isDisplayed();
	}
	
	public LoginPage ClickonloginButtonTest()
	{
		logoutbutton.click();
		return new LoginPage();
	}
	
	

}
