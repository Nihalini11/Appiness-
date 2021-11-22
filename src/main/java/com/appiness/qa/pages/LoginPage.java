package com.appiness.qa.pages;

import static org.testng.Assert.assertEquals;

import java.nio.file.ReadOnlyFileSystemException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.appiness.qa.base.TestBase;

public class LoginPage extends TestBase{
	 
	//Page Factory - OR:
	@FindBy(xpath="//input[@placeholder='Enter your email']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\'root\']/div/div/div[2]/button[2]")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\'root\']/div/div/h2")
	WebElement heading;
	
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	WebElement resetbutton;
	
	@FindBy(xpath="//p[contains(text(),'Email')]")
	WebElement EmailText;
	
	@FindBy(xpath="//p[contains(text(),'Password')]")
	WebElement Passwordtext;
	
	@FindBy(xpath="//*[@id=\'root\']/div/div/p")
	WebElement IncorrectWorning;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/p[2]")
	WebElement EmptyUserNamewarning;
	
	@FindBy(xpath="//p[contains(text(),'Must be an Alphanumeric with a length of atleast 6 characters')])")
	WebElement EmptyPasswordWarning;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/button")
	WebElement EyeSymbol;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public HomePage login(String un, String pwd){
		username.clear();
		password.clear();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click(); 

		    	
		return new HomePage();
	}
	public void Incorrectusernamepassword(String un, String pwd){
		resetbutton.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		String Inc=IncorrectWorning.getText();
		Assert.assertEquals(Inc,"Either email or password is wrong");
		
	}
	public void EmptyUsername(String un, String pwd){
		resetbutton.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		String Inc=EmptyUserNamewarning.getText();
		Assert.assertEquals(Inc,"Enter a valid email address");
		
	}
	
	public void EmptyPassword(String un, String pwd){
		resetbutton.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		String Inc=EmptyPasswordWarning.getText();
		System.out.println("Inc");
		Assert.assertEquals(Inc,"Must be an Alphanumeric with a length of atleast 6 characters");
		
	}
	
	public boolean verifyVisibiltyofHeadingLoginTest()
	{
		return heading.isDisplayed();
		
	}
	
	public  void  verifyheadingTextLoginTest()
	{
		String  loginheader= heading.getText();
		Assert.assertEquals(loginheader, "Login");
	}
	
	public boolean VerifyResetButtonTest()
	{
		return resetbutton.isDisplayed();
	}
	
	public boolean VerifyEmailtextpresentTest()
	{
		return EmailText.isDisplayed();
	}
	
	public  void  VerifycorrectEmailTextTest()
	{
		 String emailText=EmailText.getText();
		 Assert.assertEquals(emailText,"Email");
		
	}

	public boolean VerifyPasswordTextpresentTest()
	{
		return Passwordtext.isDisplayed();
	}
	
	public  void VerifycorrectpasswordTextTest()
	{
		 String passwordtext=Passwordtext.getText();
		 Assert.assertEquals(passwordtext, "Password","password text is incorrect");
	}
	
	public boolean VerifyPresenceofEyeSymbol()
	{
		return EyeSymbol.isDisplayed();
		
	}
	
	
	
	
    
	
}
