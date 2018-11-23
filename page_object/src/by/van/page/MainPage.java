package by.van.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Вылетает из...']")
    public WebElement fromField;


    @FindBy(xpath = "//input[@placeholder='Куда вы летите?']")
    public WebElement toField;


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

}
