package by.van;

import by.van.common.FlightData;
import by.van.common.PassangerData;
import by.van.page.BookPage;
import by.van.page.CheckinPage;
import by.van.page.MainPage;
import by.van.steps.MainPageSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Tests {
   private WebDriver driver;
   private MainPage mainPage;
   private CheckinPage checkinPage;
   private BookPage bookPage;
   private MainPageSteps mainPageSteps;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.gecko.driver","resources/geckodriver");

        driver = new FirefoxDriver();
        driver.get("https://www.icelandair.com/ru-ru/");
        mainPage = new MainPage(driver);
        checkinPage = new CheckinPage(driver);
        bookPage = new BookPage(driver);

        mainPageSteps = new MainPageSteps(driver);
    }

    @Test
    public void getNotFoundWarningOnInvalidFromCity() {
        FlightData data = new FlightData();
        data.setFlightStartingPoint("Muhograd");

        Assert.assertTrue(mainPageSteps.notFoundWarningIsPresent(data));
    }

    @Test
    public void atLeastOneAdultShouldBeOnBoard() {
        FlightData data = new FlightData();
        data.setFlightStartingPoint("Amsterdam");
        data.setFlightDestinationPoint("Boston");

        Assert.assertTrue(mainPageSteps.adultIsOnBoard(data));
    }

    @Test
    public void shouldNotCheckInWithInvalidData() {
        PassangerData data = new PassangerData();
        data.setLastName("Test");
        data.setBookingReference("TestCode");

        mainPageSteps.fillCheckinData(data);
        String expectedError = "ERROR: Invalid Data Entered";

        Assert.assertEquals(checkinPage.getMessageTitle(), expectedError);
    }

    @Test
    public void shouldEraseArrivalAirportWhenItEqualsDeparture() {
        FlightData data = new FlightData();
        data.setFlightDestinationPoint("Amsterdam");
        data.setFlightStartingPoint("Amsterdam");

        String expectedAirportTitle = "";

        Assert.assertEquals(mainPageSteps.getDestinationPointAfterEqualStartingPointEntered(data), expectedAirportTitle);
    }

//    @Test
//    public void ticketsShouldBeAvailible() {
//        FlightData data = new FlightData();
//        data.setFlightStartingPoint("Amsterdam");
//        data.setFlightDestinationPoint("Boston");
//        mainPageSteps.chooseOneWayDefaultFlight(data);
//
//        Assert.assertTrue(bookPage.isTicketAvailible());
//    }

    @AfterMethod
    public void close() {
        driver.close();
    }
}