package com.SampleProject.scrp;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.SampleProject.Base.TestBase;
import com.SampleProject.Constants.Messages;
import com.SampleProject.Pages.FlightPage;
import com.SampleProject.Utilities.PageUtilities;

public class FlightTest extends TestBase{
	FlightPage objFlight;
	/*@Test(priority=1,description="verifying Flightpage title")
	  public void verifyFlightPageTitle() {
		  objFlight=new FlightPage(driver);
		  objFlight.clickFlightButton();		
	objFlight.getFlightPageTitle();
	Assert.assertEquals(objFlight.getFlightPageTitle(),Messages.FLIGHTTITLE);
	}*/
	@Test(priority=5,description="verifying roundTrip is selected by default",groups= {"smoke"})
	  public void verifyRoundTripStatus() {
		  objFlight=new FlightPage(driver);
		  objFlight.clickFlightButton();
		 boolean roundtripSelected=objFlight.tripTypeSelected();
		 AssertJUnit.assertEquals(roundtripSelected,Messages.ROUNDTRIP_STATUS);
		//  Assert.assertTrue(objFlight.tripTypeSelected());
	}
	@Test(priority=6,enabled=false,description="verify Oneway button is selected")
  public void verifyOnewayButtonEnabled() {
	  objFlight=new FlightPage(driver);		
AssertJUnit.assertTrue(objFlight.tripTypeOnewaySelect());
  }
	
	
	@Test(priority=7,description="verifying the selected value 2 in the dropdown passenger ")
	  public void verifyPassengerCount() {
		  objFlight=new FlightPage(driver);
		String passengerSelectedValue=  objFlight.selectPassengerCount();
		  AssertJUnit.assertEquals(passengerSelectedValue,Messages.PASSENGER_COUNT);
	}
	@Test(priority=8,description="verifying the selected value London in the dropdown departFrom ")
	  public void verifyDeparturePlace() {
		  objFlight=new FlightPage(driver);
		String departFrom=  objFlight.selectDepature();
		  AssertJUnit.assertEquals( departFrom,Messages.DEPART_PLACE);
	}
	@Test(priority=9,enabled=false,description="verifying the selected month is April ")
	  public void verifyDepartureMonth() {
		  objFlight=new FlightPage(driver);
		String depatMonth=  objFlight.selectDepatureMonth();
		AssertJUnit.assertEquals(depatMonth, Messages.DEPART_MONTH);
	}
@Test(priority=10,enabled=false,description="verifying the businessClass buttonis selected")
	  public void verifyBussinessClassButtonEnabled() {
		  objFlight=new FlightPage(driver);	
		 AssertJUnit.assertTrue(objFlight.serviceClassSelected());
}
}
