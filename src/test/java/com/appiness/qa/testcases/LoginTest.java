package com.appiness.qa.testcases;


import org.testng.Assert;
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
public class LoginTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest(){
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		initialization();
		
		loginPage = new LoginPage();	
	}
	

	
	@Test(priority=12)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login Succesful");
	}
	@Test(priority=1)
	public void VerifyTitleofWebsiteTest()
	{
		String ExpectedTitle="React App";
		Assert.assertEquals(ExpectedTitle,driver.getTitle());
		System.out.println("title displaying as expected");
		
	}
	
	@Test(priority=3)
	public void VerifyUsername()
	{
		Assert.assertTrue(loginPage.verifyVisibiltyofHeadingLoginTest());
		
		System.out.println("login heading is present");
		
	}
	
	@Test(priority=2)
	public void verifytextlogin()
	{
		loginPage.verifyheadingTextLoginTest();
		
	}
	
	@Test(priority=8)
	public void verifyResetbutton()
	{
		
		Assert.assertTrue(loginPage.VerifyResetButtonTest(),"reset button not present");
		System.out.println("reset button verified");
		}
	@Test(priority=4)
	public void VerifyEmailText()
	{
		loginPage.VerifycorrectEmailTextTest();
	}
	
	@Test(priority=5)
	public void VerifyEmailTextPresence()
	{
		loginPage.VerifyEmailtextpresentTest();
	}
	@Test(priority=6)
	public void VerifypaaswordText()
	{
		loginPage.VerifycorrectpasswordTextTest();
	}
	
	@Test(priority=7)
	public void VerifyPasswordTextPresence()
	{
		loginPage.VerifyPasswordTextpresentTest();
	}
	
	@Test(priority=8)
	public void VerifyEyeSymbol()
	{
		loginPage.VerifyPresenceofEyeSymbol();
		System.out.println("eye symbol is displaying as expected");
	}
	@Test(priority=9)
	public void IncorrectEmailPassword()
	{
		loginPage.Incorrectusernamepassword("niha", "124");
	}
	@Test(priority=10)
	public void EmptyUsername()
	{
		loginPage.EmptyUsername("", prop.getProperty("password"));
	}
	@Test(priority=11)
	public void EmptyPassword()
	{
		loginPage.EmptyPassword(prop.getProperty("urname"), "");
	}
	
	 
	@AfterTest
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	
	

}