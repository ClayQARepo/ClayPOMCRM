package com.crm.clay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.clay.base.TestBase;

public class LoginPage extends TestBase{
	//PageFactory
	@FindBy(name ="email")
	WebElement useremail;
	
	@FindBy(name ="password")
	WebElement userpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//img[@alt='Company logo']")
	WebElement logo;
	
	@FindBy(xpath="//*[text()='No email and password combination was found.']")
	WebElement errorMsg;
	
	@FindBy(linkText = "I forgot my password")
	WebElement forgotPass;
	
	@FindBy(xpath="//*[text()='Email Sent!']")//need to change
	WebElement resetMsg;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String LoginPageTitle() {
		return driver.getTitle();
		
	}
	public Boolean LoginPageLogo() {
		return logo.isDisplayed();
		
	}
	public HomePage Login(String un, String pw) {
		useremail.sendKeys(un);
		userpassword.sendKeys(pw);
		submitBtn.click();
		return new HomePage();
	}
	public String ValidateLoginErrorMsg() {
		return errorMsg.getText();
	}
	public void ValidateResetPassword(String un) throws InterruptedException {
		forgotPass.click();
		Thread.sleep(5000);
		useremail.sendKeys(un);
		submitBtn.click();		
	}
	public String ValidateResetMsg() {
		return resetMsg.getText();
	}
	

}
