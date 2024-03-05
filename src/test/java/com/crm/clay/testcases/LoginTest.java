package com.crm.clay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.crm.clay.base.TestBase;
import com.crm.clay.pages.HomePage;
import com.crm.clay.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title=lp.LoginPageTitle();
		Assert.assertEquals(title,"Clay - Sales Portal");
	}
	@Test(priority=2)
	public void LoginPageLogoTest() {
		boolean logo1=lp.LoginPageLogo();
		Assert.assertTrue(logo1);
	}
	@Test(priority=3)
	public void LoginPageTest() {
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));	
		Assert.assertTrue(hp.ValidateHomePage());
	}
	@Test(priority=4)
	public void UnsuccessfulLoginErrorMsg() {
		lp.Login("clay@yopmail.com", "Test123");
		String errormsg=lp.ValidateLoginErrorMsg();
		Assert.assertEquals(errormsg, "No email and password combination was found.");
	}
	@Test(priority=5)
	public void ResetPasswordTest() throws InterruptedException {
		lp.ValidateResetPassword(prop.getProperty("username"));
		Thread.sleep(3000);
		String rm=lp.ValidateResetMsg();
		
		Assert.assertEquals(rm, "Email Sent!");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
