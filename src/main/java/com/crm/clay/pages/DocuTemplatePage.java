package com.crm.clay.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
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
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement EnvType;////div[contains(text(),'Select Envelope Type')]
	
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
	
	@FindBy(xpath="//tr[contains(@class,'text-small')]/td[3]")
	WebElement EnvFirstNameinList;
	
	@FindBy(xpath="//table[@class='table-auto']/tbody//tr/td[3]")
	List<WebElement> DraftList;
	
	@FindBy(xpath="//div[contains(text(),'Front Page')]")
	WebElement FrontPage;
	
	@FindBy(xpath="//div[contains(text(),'Other Documents')]")
	WebElement OtherDoc;
	
	@FindBy(xpath="//button[@aria-haspopup='listbox']")
	WebElement OtherDealType;
	
	@FindBy(xpath="//div[contains(text(),'Decor')]")
	WebElement DecorDoc;
	
	@FindBy(xpath="//div[contains(text(),'Automation')]")
	WebElement AutomationDoc;
	
	@FindBy(xpath="(//button[contains(@class, 'inline-flex') and @data-slot='trigger'])[3]")
	WebElement FirstActionicon;////li[@role='menuitem'][3]
	
	@FindBy(xpath="//li[@role='menuitem'][3]")
	WebElement EditBtn;
	
	Actions builder=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Constructor of class
	public DocuTemplatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void ClickDocuTempOpt() {
		dtempBtn.click();
	}
	public void ClickAddEnvelope() {
		AddEnvBtn.click();
	}
	public void ClickOtherDoc() {
		builder.click(OtherDoc).build().perform();
	}
	
	public void ClickDecorDoc() {
		builder.click(DecorDoc).build().perform();
	}
	public void ClickAutomationDoc() {
		builder.click(AutomationDoc).build().perform();
	}
	public void ClickActionbutton() {
		FirstActionicon.click();
	}
	
	
	//Add Envelope
		public void AddEnvelope(String name) throws InterruptedException {
			
			String AbsPath="C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
			EnvName.click();
			EnvName.sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(EnvType));
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();",EnvType);
			Actions builder=new Actions(driver);
			builder.click(EnvType).build().perform();
			Thread.sleep(2000);
			ClickCat.click();
			Thread.sleep(2000);
			SlctCatOpt.click();
			Thread.sleep(2000);
			builder.click(ClickDealType).build().perform();
			SlctDealType.click();
			EnvType.click();
			Thread.sleep(2000);
			builder.click(AttachDoc).build().perform();
			BrwsBtn.sendKeys(AbsPath);
			System.out.println("File is Uploaded Successfully");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
			Thread.sleep(2000);
			builder.click(SignerRole).build().perform();
			SlctSigner.click();

		}
	
	//create Other Envelope
	public void createOtherDoc(String name) throws InterruptedException {
		String AbsPath="C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
		EnvName.click();
		EnvName.sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(EnvType));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();",EnvType);
		
		builder.click(EnvType).build().perform();
		Thread.sleep(2000);
		builder.click(OtherDoc).build().perform();
		Thread.sleep(2000);
		builder.click(OtherDealType).build().perform();
		SlctDealType.click();
		EnvType.click();
		Thread.sleep(2000);
		builder.click(AttachDoc).build().perform();
		BrwsBtn.sendKeys(AbsPath);
		System.out.println("File is Uploaded Successfully");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
		Thread.sleep(2000);
		builder.click(SignerRole).build().perform();
		SlctSigner.click();
	}	
	
	//create Decor Envelope
	public void createDecorDoc(String name) throws InterruptedException {
		String AbsPath="C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
		EnvName.click();
		EnvName.sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(EnvType));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();",EnvType);
		
		builder.click(EnvType).build().perform();
		Thread.sleep(2000);
		builder.click(DecorDoc).build().perform();
		Thread.sleep(2000);
		builder.click(OtherDealType).build().perform();
		SlctDealType.click();
		EnvType.click();
		Thread.sleep(2000);
		builder.click(AttachDoc).build().perform();
		BrwsBtn.sendKeys(AbsPath);
		System.out.println("File is Uploaded Successfully");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
		Thread.sleep(2000);
		builder.click(SignerRole).build().perform();
		SlctSigner.click();
	}
	//create Automation Envelope
	public void createAutomationDoc(String name) throws InterruptedException {
		String AbsPath="C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
		EnvName.click();
		EnvName.sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(EnvType));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();",EnvType);
		
		builder.click(EnvType).build().perform();
		Thread.sleep(2000);
		builder.click(AutomationDoc).build().perform();
		Thread.sleep(2000);
		builder.click(OtherDealType).build().perform();
		SlctDealType.click();
		EnvType.click();
		Thread.sleep(2000);
		builder.click(AttachDoc).build().perform();
		BrwsBtn.sendKeys(AbsPath);
		System.out.println("File is Uploaded Successfully");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
		Thread.sleep(2000);
		builder.click(SignerRole).build().perform();
		SlctSigner.click();
	}
	
	//ADD all categories Envelope
		public void ValidatethedropdownCategory(String name) throws InterruptedException {
			String AbsPath = "C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java\\com\\crm\\clay\\pages\\Glenway Urban Towns Colours Jan 7th, 2024.docx";
			EnvName.click();
			EnvName.sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(EnvType));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", EnvType);
			Actions builder = new Actions(driver);
			builder.click(EnvType).build().perform();
			Thread.sleep(2000);
			ClickCat.click();

			List<WebElement> allOptions = ALLCatOPT;
			System.out.println(allOptions.size());

			for (int i = 0; i < allOptions.size(); i++) {

				System.out.println(allOptions.get(i).getText());
				allOptions.get(i).click();
				// ClickCat.click();
				Thread.sleep(2000);
				builder.click(ClickDealType).build().perform();
				SlctDealType.click();
				EnvType.click();
				Thread.sleep(2000);
				builder.click(AttachDoc).build().perform();

				BrwsBtn.sendKeys(AbsPath);

				System.out.println("File is Uploaded Successfully");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignerRole);
				Thread.sleep(2000);
				builder.click(SignerRole).build().perform();
				SlctSigner.click();
				NextBtn.click();
				Thread.sleep(10000);
				Assert.assertTrue(ValidateIframe());
				dtempBtn.click();
				AddEnvBtn.click();
				// driver.navigate().refresh();
				/*
				 * try { wait.until(ExpectedConditions.elementToBeClickable(EnvName));
				 * EnvName.click(); EnvName.sendKeys(name); } catch
				 * (StaleElementReferenceException e) { // Refresh the page
				 * driver.navigate().refresh();
				 * 
				 * // Try to locate the element again EnvName.click();
				 * 
				 * }
				 */
				Thread.sleep(2000);
				// wait.until(ExpectedConditions.elementToBeClickable(EnvName));
				builder.doubleClick(EnvName).build().perform();
				EnvName.sendKeys(name);

				wait.until(ExpectedConditions.elementToBeClickable(EnvType));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", EnvType);
				builder.click(EnvType).build().perform();
				wait.until(ExpectedConditions.elementToBeClickable(ClickCat));
				builder.click(ClickCat).build().perform();
			}
			// Close the browser
			driver.quit();

		}
		//method to find last created envelope in  list
		public String GetListofEnv() throws InterruptedException {
			 List<WebElement> listOfEnv = DraftList;
			    System.out.println(listOfEnv.size());

			    for (int i = 0; i < listOfEnv.size(); i++) {
			    //    System.out.println(listOfEnv.get(i));
			    }

			    // Return the text of the last element
			    if (!listOfEnv.isEmpty()) {
			        return listOfEnv.get(listOfEnv.size() - 1).getText();
			    } else {
			        return ""; // Return empty string if the list is empty
			    }
			
			/*
			 * List<WebElement> listOfEnv= DraftList; System.out.println(listOfEnv.size());
			 * StringBuilder result = new StringBuilder(); // StringBuilder to concatenate
			 * loop values
			 * wait.until(ExpectedConditions.visibilityOfAllElements(listOfEnv)); for(int
			 * i=0;i<listOfEnv.size();i++){ System.out.println(listOfEnv.get(i).getText());
			 * result.append(listOfEnv.get(i).getText()).append("\n"); // Append each
			 * valueto StringBuilder }
			 * 
			 * return result.toString();
			 */
		}
		//hover and click more actions
		public void HoverClickActionBtn() throws InterruptedException {
			Thread.sleep(3000);
			builder.moveToElement(EnvFirstNameinList).build().perform();
			Thread.sleep(2000);
			builder.click(FirstActionicon).build().perform();
			
		}
		
		public void ChangeEnvName(String name) {
			builder.doubleClick(EnvName).build().perform();
			EnvName.clear();
			
			EnvName.sendKeys(name);
		}
		public void ClickEditBtn() {
			builder.click(EditBtn).build().perform();
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

		public String VerifyEnvNameInList() {
			System.out.println(EnvFirstNameinList);
			return EnvFirstNameinList.getText();
		}

		public void ClickDraftPage() {
			// ClickDraftPage.click();
			builder.click(ClickDraftPage).build().perform();
		}

		public String GetEnvNameValue() {
			String envValue = EnvName.getAttribute("value");
			System.out.println(envValue);
			return envValue;
		}

		public void ClickFrontPage() {
			FrontPage.click();
			// attempt to refresh

		}	

	
	
	public void CreateTemplate() {
		 // Replace x_offset and y_offset with the desired coordinates
        int x_offset = 300;
        int y_offset = 60;
		driver.switchTo().frame(IframeEntity);
		//return DragSign.getText();
		Actions builder= new Actions(driver);
		builder.dragAndDrop(DragSign,DropSign).build().perform();
		
		
	}//get env name in string then compare it with for loop
	
	




}
