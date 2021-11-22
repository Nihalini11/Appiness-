package com.appiness.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.appiness.qa.base.TestBase;
import com.appiness.qa.pages.HomePage;
import com.appiness.qa.pages.LoginPage;
 @Listeners(CustomListener.class)
public class HomeTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomeTest()
	{ 
		super();
	}
	@BeforeTest
	public void SetUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomepageHeaderTest()
	{
		homePage.VerifyHomepageHeader();
	}
	
	@Test(priority=2)
	public void VerifyEmailInHomepageTest()
	{
		homePage.VerifyEmailInHomepageTest();
	}
	@Test(priority=3)
	public void VerifyTablePresenceTest()
	{
		homePage.VerifyTablePresenceTest();
	}
	@Test(priority=4)
	public void logoutButtonPresenceTest()
	{
		homePage.logoutButtonPresenceTest();
	}
	@Test(priority=5)
	public void ClickonloginButtonTest()
	{
		homePage.ClickonloginButtonTest();
	}

	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}

}
