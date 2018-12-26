package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit' and @class='button']")
	WebElement saveBtn;
	

//	Initialize page factory:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
//	Actions:
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']")).click();
	}
	
	public void createNewContact(String title, String ftname, String ltname, String comp) {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
		 
	}
	
	public void selectOption(String text) {
		Select select1 = new Select(driver.findElement(By.xpath("//select[@name='do_action']")));
		select1.selectByVisibleText(text);
	}
}
