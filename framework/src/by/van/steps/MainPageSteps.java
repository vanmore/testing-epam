package by.van.steps;

import by.van.common.FlightData;
import by.van.common.PassangerData;
import by.van.page.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public Boolean notFoundWarningIsPresent(FlightData data) {
        mainPage.setFlightStartingPoint(data.getFlightStartingPoint());
        return mainPage.notFoundWarningIsPresent();
    }

    public Boolean adultIsOnBoard(FlightData data) {

        mainPage.setFlightStartingPoint(data.getFlightStartingPoint());
        mainPage.setFlightDestinationPoint(data.getFlightDestinationPoint());
        mainPage.setOnewWayDirection();
        mainPage.passangersField.click();
        mainPage.addChild();
        mainPage.removeAdult();

        return mainPage.adultIsOnBoard();
    }

    public void chooseOneWayDefaultFlight(FlightData data) {
        mainPage.setFlightStartingPoint(data.getFlightStartingPoint());
        mainPage.setFlightDestinationPoint(data.getFlightDestinationPoint());
        mainPage.setOnewWayDirection();
        mainPage.searchFlightsButton.click();
    }

    public void fillCheckinData(PassangerData data) {
        mainPage.checkinButton.click();
        mainPage.setCheckinLastNameField(data.getLastName());
        mainPage.setCheckinBookingReferenceField(data.getBookingReference());
    }


//    public String getErrorWhenDataForCheckinIsInvalid(PassangerData data) {
//        mainPage.checkinButton.click();
//        mainPage.setCheckinLastNameField(data.getLastName());
//        mainPage.setCheckinBookingReferenceField(data.getBookingReference());
//
//        return mainPage.getMessageTitle();
//    }

    public String getDestinationPointAfterEqualStartingPointEntered(FlightData data) {
        mainPage.setFlightStartingPoint(data.getFlightStartingPoint());
        mainPage.setFlightDestinationPoint(data.getFlightDestinationPoint());

        return mainPage.getFlightDestinationPointText();
    }
}
