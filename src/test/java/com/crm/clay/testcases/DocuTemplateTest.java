package com.crm.clay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.clay.base.TestBase;
import com.crm.clay.pages.DocuTemplatePage;
import com.crm.clay.pages.HomePage;
import com.crm.clay.pages.LoginPage;

public class DocuTemplateTest extends TestBase {


	HomePage hp;
	LoginPage lp;
	DocuTemplatePage dp;
	
	public DocuTemplateTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		hp=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		dp=new DocuTemplatePage();
		//hp.ClickProject();
		
	}
	
	@Test
	public void CreateEnvelopeTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.AddEnvelope(namedate);
		dp.ClickNextBtn();
		Assert.assertTrue(dp.ValidateIframe());
		//Thread.sleep(10000);
		//dp.CreateTemplate();
		
	}
	@Test
	public void APSALLCategoryTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.ValidatethedropdownCategory(namedate);
	}
	
	@Test
	public void VerifyDraftTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.AddEnvelope(namedate);
		dp.ClickDraftBtn();
		dp.ClickDraftPage();
		Thread.sleep(10000);
		//Assert.assertEquals(dp.VerifyEnvNameInList(), namedate);
		dp.GetListofEnv();
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
