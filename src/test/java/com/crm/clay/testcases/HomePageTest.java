package com.crm.clay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.clay.base.TestBase;
import com.crm.clay.pages.HomePage;
import com.crm.clay.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage hp;
	LoginPage lp;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		hp=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void VerifyHomePageTest() {
		Assert.assertTrue(hp.ValidateHomePage());
	}
	
	@Test(priority=2)
	public void VerfyProjectDashboard(){
		hp.ClickProject();
		Assert.assertTrue(hp.Projectdashboard());
	}
	
	@Test(priority=3)
	public void VerifyProjectPage() {
		hp.ClickProject();
		Assert.assertTrue(hp.Projectdashboard());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
