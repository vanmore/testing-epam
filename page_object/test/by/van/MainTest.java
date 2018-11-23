package by.van;

import by.van.page.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class MainTest {
   private WebDriver driver;
   private MainPage page;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.gecko.driver","resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.icelandair.com/ru-ru/");
        page = new MainPage(driver);
    }

    @Test
    public void getNotFoundWarningOnInvalidFromCity() {
        page.setFlightStartingPoint("Muhograd");
        Assert.assertTrue(page.notFoundWarningIsPresent());
    }

    @Test
    public void atLeastOneAdultShouldBeOnBoard() {
        page.setFlightStartingPoint("Amsterdam");
        page.setFlightDestinationPoint("Boston");
        page.setOnewWayDirection();
        page.passangersField.click();
        page.addChild();
        page.removeAdult();
        Assert.assertTrue(page.adultIsOnBoard());
    }

    @AfterMethod
    public void close() {
        driver.close();
    }
}