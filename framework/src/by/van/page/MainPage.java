package by.van.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='Вылетает из...']")
    public WebElement fromField;


    @FindBy(xpath = "//input[@placeholder='Куда вы летите?']")
    public WebElement toField;


    //div[contains(@class, 'measure-tab') and contains(.//span, 'someText')]
    @FindBy(xpath = "//div[contains(@class, 'react-tabs')]//span[text()='Регистрация']")
    public WebElement checkinButton;


    @FindBy(xpath = "//div[contains(@class, 'react-tabs')]//input[@placeholder='Укажите свою фамилию']")
    public WebElement checkinLastNameField;


    @FindBy(xpath = "//button[@id='booking_search_button']")
    public WebElement searchFlightsButton;

    @FindBy(xpath = "//div[contains(@class, 'react-tabs')]//input[@placeholder='Он может выглядеть так: A6543F']")
    public WebElement checkinBookingReferenceField;

    @FindBy(xpath = "//span[preceding::input[@value='ONEWAY']]")
    public WebElement oneWayRadioButton;

    @FindBy(xpath = "//div[text()='1 пассажиров']/parent::div")
    public WebElement passangersField;

    @FindBy(xpath = "//button[@aria-label='Дети increment']")
    public WebElement addChildButton;


    @FindBy(xpath = "//button[@aria-label='Взрослые decrement']")
    public WebElement removeAdultButton;

    @FindBy(xpath = "//div[preceding::button[@aria-label='Взрослые decrement']]")
    public WebElement numOfAdultsDisplayer;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public Boolean notFoundWarningIsPresent() {
        return !driver
                .findElements(By.xpath("//div[text()='Не найдено ни одного результата']"))
                .isEmpty();
    }

    public void setFlightStartingPoint(String city) {
        fromField.sendKeys(city);
        fromField.sendKeys(Keys.ENTER);
    }

    public void setFlightDestinationPoint(String city) {
        toField.sendKeys(city);
        toField.sendKeys(Keys.ENTER);
    }

    public String getFlightDestinationPointText() {
        return toField.getText();
    }

    public void setCheckinLastNameField(String lastName) {
        checkinLastNameField.sendKeys(lastName);
        checkinLastNameField.sendKeys(Keys.ENTER);
    }

    public void setCheckinBookingReferenceField(String code) {
        checkinBookingReferenceField.sendKeys(code);
        checkinBookingReferenceField.sendKeys(Keys.ENTER);
    }
//
//    public String getMessageTitle() {
//        return checkVisibility(messageTitle).getText();
//    }

    public void setOnewWayDirection() {
        oneWayRadioButton.click();
    }

    public void addChild() {
        addChildButton.click();
    }

    public void removeAdult() {
        removeAdultButton.click();
    }

    public boolean adultIsOnBoard() {
        return Integer.parseInt(numOfAdultsDisplayer.getText()) > 0;
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
