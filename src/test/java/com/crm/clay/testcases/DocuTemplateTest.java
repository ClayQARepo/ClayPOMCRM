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
		dp=new DocuTemplatePage(driver);
		//hp.ClickProject();
		
	}
	
	@Test(priority=1)
	public void CreateEnvelopeTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.AddEnvelope(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickNextBtn();
		Assert.assertTrue(dp.ValidateIframe());
		dp.ClickDocuTempOpt();
		dp.ClickFrontPage();
		driver.navigate().refresh();
	//	Thread.sleep(10000);
		Assert.assertEquals(dp.GetListofEnv(), str);
		
	}
	
	@Test(priority=3)
	public void CreateEnvelopeinOtherCategoryTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.createOtherDoc(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickNextBtn();
		Assert.assertTrue(dp.ValidateIframe());
		dp.ClickDocuTempOpt();
		Thread.sleep(2000);
		dp.ClickOtherDoc();
		//driver.navigate().refresh();
		Thread.sleep(10000);
		Assert.assertEquals(dp.GetListofEnv(), str);
		
	}
	@Test(priority=4)
	public void CreateEnvelopeinDecorCategoryTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.createDecorDoc(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickNextBtn();
		Assert.assertTrue(dp.ValidateIframe());
		dp.ClickDocuTempOpt();
		Thread.sleep(2000);
		dp.ClickDecorDoc();
		Thread.sleep(10000);
		Assert.assertEquals(dp.GetListofEnv(), str);
		
	}
	
	@Test(priority=5)
	public void CreateEnvelopeinAutomationCategoryTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.createAutomationDoc(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickNextBtn();
		Assert.assertTrue(dp.ValidateIframe());
		dp.ClickDocuTempOpt();
		Thread.sleep(2000);
		dp.ClickAutomationDoc();
		Thread.sleep(10000);
		Assert.assertEquals(dp.GetListofEnv(), str);
		
	}
	@Test(priority=6)
	public void OtherDraftEnvelopeTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.createOtherDoc(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickDraftBtn();
		dp.ClickDocuTempOpt();
		Thread.sleep(2000);
		dp.ClickOtherDoc();
		dp.ClickDraftPage();
		//driver.navigate().refresh();
		Assert.assertEquals(dp.GetListofEnv(), str);
	}
	@Test(priority=7)
	public void DecorDraftEnvelopeTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.createDecorDoc(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickDraftBtn();
		dp.ClickDocuTempOpt();
		Thread.sleep(2000);
		dp.ClickDecorDoc();
		dp.ClickDraftPage();
		//driver.navigate().refresh();
		Assert.assertEquals(dp.GetListofEnv(), str);
	}
	
	@Test(priority=2)
	public void VerifyDraftTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.AddEnvelope(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickDraftBtn();
		dp.ClickDraftPage();
		Assert.assertEquals(dp.GetListofEnv(), str);
	}
	@Test(priority=8)
	public void APSALLCategoryTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.ClickAddEnvelope();
		Thread.sleep(3000);
		String namedate="Envelope Test Automation " +currentDate;
		dp.ValidatethedropdownCategory(namedate);
	}
	@Test
	public void EditEnvelopeTest() throws InterruptedException {
		hp.ClickProject();
		dp.ClickDocuTempOpt();
		dp.HoverClickActionBtn();
		dp.ClickActionbutton();
		dp.ClickEditBtn();
		Thread.sleep(3000);
		String namedate="test edit";
		dp.ChangeEnvName(namedate);
		String str=dp.GetEnvNameValue();
		dp.ClickNextBtn();
		Assert.assertTrue(dp.ValidateIframe());
		dp.ClickDocuTempOpt();
		dp.ClickFrontPage();
		dp.VerifyEnvNameInList();
		Assert.assertEquals(dp.VerifyEnvNameInList(), str);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
