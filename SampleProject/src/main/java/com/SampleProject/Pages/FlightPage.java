package com.SampleProject.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.SampleProject.Utilities.WaitUtilities;

public class FlightPage {
	public WebDriver driver;
	@FindBy(linkText="Flights")
	WebElement flight;
	
	//@FindBy(xpath="//input[@value='roundtrip']")
//	WebElement tripTypeRoundtrip;
	//@FindBy(xpath="//input[@value='oneway']")
	//WebElement tripTypeOneway;
	
	@FindBy(xpath="//input[@name='tripType']")
	List<WebElement>tripType;
	@FindBy(xpath="//select[@name='passCount']")
	WebElement passenger;
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement depart;
	@FindBy(xpath="//select[@name='fromMonth']")
	WebElement departMonth;
	@FindBy(xpath="//select[@name='fromDay']")
	WebElement departDay;
	@FindBy(xpath="//select[@name='toPort']")
	WebElement arrival;
	@FindBy(xpath="//select[@name='toMonth']")
	WebElement arrivalMonth;
	@FindBy(xpath="//select[@name='toDay']")
	WebElement arrivalDay;
	@FindBy(xpath="//input[@name='servClass']")
	List<WebElement> serviceClass;
	@FindBy(xpath="//select[@name='airline']")
	WebElement airline;
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continu;
	
	public FlightPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightButton() {
		flight.click();
	}
	
	public boolean tripTypeSelected() {
		WaitUtilities.explicitWait(driver, tripType.get(0));
		boolean tripTypeStatus=tripType.get(0).isSelected();
		return tripTypeStatus;
	}
	public boolean tripTypeOnewaySelect() {	
		tripType.get(1).click();
		boolean tripTypeOnewayStatus=tripType.get(1).isSelected();
		return tripTypeOnewayStatus;
	}
	public String selectPassengerCount() {
		Select s=new Select(passenger);
		s.selectByIndex(1);
	List<WebElement>data=s.getOptions();

		System.out.println(data.get(1).getText());
	return (data.get(1).getText());
	}
	public String selectDepature() {
		Select s=new Select(depart);
		s.selectByIndex(2);
		List<WebElement>data=s.getOptions();
		System.out.println(data.get(2).getText());
		return (data.get(2).getText());

	}
	public String selectDepatureMonth() {
		Select s=new Select(departMonth);
		s.selectByIndex(1);
List<WebElement>data=s.getOptions();
return(data.get(1).getText());
	}
	
	public boolean serviceClassSelected() {
		serviceClass.get(1).click();
		boolean classStatus=serviceClass.get(1).isSelected();
		return classStatus;
		
	}
	public void selectDepatureDay() {
		Select s=new Select(departDay);
		s.selectByIndex(4);
	}
	public void selectArrival() {
		Select s=new Select(arrival);
		s.selectByIndex(5);
	}
	public void selectArrivalMonth() {
		Select s=new Select(arrivalMonth);
		s.selectByIndex(2);
	}
	public void selectArrivalDay() {
		Select s=new Select(arrivalDay);
		s.selectByIndex(10);
	}
	
	public void selectAirline() {
		Select s=new Select(airline);
		s.selectByIndex(1);
	}
	
	public String getFlightPageTitle() {
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	



}
