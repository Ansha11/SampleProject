package com.SampleProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SampleProject.Utilities.PageUtilities;

public class RegisterPage {
	public WebDriver driver;

	@FindBy(linkText="REGISTER")
	WebElement register;
	@FindBy(name="firstName")
	WebElement firstname;
	@FindBy(name="lastName")
	WebElement lastname;
	@FindBy(name="address1")
	WebElement address;

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegister() {
		register.click();
	}
	public void setfirstname() {
		//firstname.sendKeys(fname);
		PageUtilities.sendText(driver, firstname);
	}
	public void setlastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void setAddress(String address1) {
		address.sendKeys(address1);
		
	}
}
