package com.crm.clay.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import com.crm.clay.base.TestBase;

public class DocuTemplatePage extends TestBase{
	//PageFactory
	@FindBy(xpath="//div[text()='DocuTemplates']")
	WebElement dtempBtn;
	
	@FindBy(xpath="//a[text()='Add Envelope']")
	WebElement AddEnvBtn;
	
	@FindBy(tagName = "input")
	WebElement EnvName;
	
	@FindBy(xpath="//div[contains(text(),'Select Envelope Type')]")
	WebElement EnvType;
	
	@FindBy(xpath="(//button[@aria-haspopup='listbox'])[1]")
	WebElement ClickCat;
	
	@FindBy(xpath="//div[@data-slot='listbox']//li")
	List<WebElement> ALLCatOPT;
	
	@FindBy(xpath="//div[@data-slot='listbox']//li[1]")
	WebElement SlctCatOpt;////div[@data-slot='listbox']//li[2]
	
	@FindBy(xpath="(//button[@aria-haspopup='listbox'])[2]")
	WebElement ClickDealType;
	
	@FindBy(xpath="//div[@data-slot='listbox']//li[1]")
	WebElement SlctDealType;

	@FindBy(xpath="//div[text()='Attach Documents']")
	WebElement AttachDoc;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement BrwsBtn;//---//input[@type='file']
	
	@FindBy(xpath="//div[contains(text(),'Select Signer Roles')]")
	WebElement SignerRole;
	
	@FindBy(xpath="//div[@role='presentation']/label[1]")
	WebElement SlctSigner;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement NextBtn;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement DraftBtn;
	
	@FindBy(name = "x-hellosign-embedded")
	WebElement IframeEntity;
	
	@FindBy (xpath="(//button[contains(@class,'src-hellospa')])[2]")
	WebElement DragSign;////button[contains(@class,'src-hellospa')])[2]-----//button[@data-dnd-id='S1']
	
	@FindBy (xpath="//div[contains(@class,'src-hellospa')]")
	WebElement DropSign;
	
	@FindBy(xpath="//div[contains(text(),'Drafts')]")
	WebElement ClickDraftPage;
	
	@FindBy(xpath="//tr[contains(@class,'text-default')]/td[3]")
	WebElement DraftEnvNameinList;
	
	@FindBy(xpath="//table[@class='table-auto']/tbody//tr")
	List<WebElement> DraftList;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//Constructor of class
	public DocuTemplatePage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public void ClickDocuTempOpt() {
		dtempBtn.click();
	}
	public void ClickAddEnvelope() {
		AddEnvBtn.click();
	}
	
	
	public void AddEnvelope(String name) throws InterruptedException {
		
		String AbsPath="C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
		EnvName.click();
		EnvName.sendKeys(name);
		EnvType.click();
		Thread.sleep(2000);
		ClickCat.click();
		Thread.sleep(2000);
		SlctCatOpt.click();
		ClickDealType.click();
		SlctDealType.click();
		EnvType.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);

		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AttachDoc));
			element.click(); // once the element is clickable, you can click it

		} catch (Exception e) { // The element was not clickable, handle it appropriately

			e.printStackTrace();
		}

		BrwsBtn.sendKeys(AbsPath);

		System.out.println("File is Uploaded Successfully");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
		SignerRole.click();
		Thread.sleep(3000);
		SlctSigner.click();
		 
		
	}
	
	public void ClickNextBtn() {
		NextBtn.click();
	}
	
	public void ClickDraftBtn() {
		DraftBtn.click();
	}
	
	public boolean ValidateIframe() {
		return IframeEntity.isDisplayed();
	}
	public void ValidatethedropdownCategory(String name) throws InterruptedException {
		String AbsPath="C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
		EnvName.click();
		EnvName.sendKeys(name);
		EnvType.click();
		Thread.sleep(2000);
		ClickCat.click();

		List<WebElement> allOptions = ALLCatOPT;
		System.out.println(allOptions.size());

		for (int i = 0; i < allOptions.size(); i++) {
		
		
			System.out.println(allOptions.get(i).getText());
			allOptions.get(i).click();
			//ClickCat.click();
			ClickDealType.click();
			SlctDealType.click();
			EnvType.click();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);

			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AttachDoc));
				element.click(); // once the element is clickable, you can click it

			} catch (Exception e) { // The element was not clickable, handle it appropriately

				e.printStackTrace();
			}

			BrwsBtn.sendKeys(AbsPath);

			System.out.println("File is Uploaded Successfully");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
			SignerRole.click();
			Thread.sleep(3000);
			SlctSigner.click();
			NextBtn.click();
			Thread.sleep(10000);
			Assert.assertTrue(ValidateIframe());
			dtempBtn.click();
			AddEnvBtn.click();
			EnvName.click();
			EnvName.sendKeys(name);
			EnvType.click();
			Thread.sleep(2000);
			ClickCat.click();
		}
		  // Close the browser
        driver.quit();
		
	}
	
	public String VerifyEnvNameInList() {
		return DraftEnvNameinList.getText();
	}
	public void ClickDraftPage() {
		ClickDraftPage.click();
	}
	public void GetListofEnv() {
		List<WebElement> listOfEnv= DraftList;
		System.out.println(listOfEnv.size());
		
		for(int i=0;i<listOfEnv.size();i++){
			System.out.println(listOfEnv.get(i).getText());
		}
	}
	
	public void CreateTemplate() {
		 // Replace x_offset and y_offset with the desired coordinates
        int x_offset = 300;
        int y_offset = 60;
		driver.switchTo().frame(IframeEntity);
		//return DragSign.getText();
		Actions builder= new Actions(driver);
		builder.dragAndDrop(DragSign,DropSign).build().perform();
		
		
	}
	
	




}
