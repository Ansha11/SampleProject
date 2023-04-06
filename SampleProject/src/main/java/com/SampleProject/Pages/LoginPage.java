package com.SampleProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SampleProject.Utilities.PageUtilities;

public class LoginPage {
	public WebDriver driver;

	@FindBy(xpath="//input[@name='userName']")
	WebElement user;
@FindBy(xpath="//input[@name='password']")
WebElement pass;
@FindBy(xpath="//input[@name='submit']")
WebElement submit;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String username) {
		user.sendKeys(username);
	}
	public void setPassword(String password) {
		pass.sendKeys(password);

	}
	public void clickSubmit() {
		//submit.click();
PageUtilities.clickElement(driver, submit);
	}
	public String getHomePageTitle() {
		String title=driver.getTitle();
		return title;
	}
}
