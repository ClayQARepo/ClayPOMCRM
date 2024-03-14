package com.crm.clay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.clay.base.TestBase;

public class HomePage extends TestBase{
	//PageFactry
	@FindBy(xpath="//div[text()='Main dashboard']")
	WebElement homepagetext;
	
	@FindBy(xpath = "//span[contains(text(),'Skybuild Desvelopters')]")
	WebElement projectname;
	
	@FindBy(xpath="//div[contains(text(),'Main dashboard')]")
	WebElement projectpage;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public Boolean ValidateHomePage() {
		return homepagetext.isDisplayed();		
	}
	public void ClickProject() {
		projectname.click();
	}
	public boolean Projectdashboard() {
		return projectpage.isDisplayed();
	}

}
