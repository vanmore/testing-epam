package by.van.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class, 'bound-table-flightline col-xs-24 ')]")
    public WebElement flightLine;

    public BookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public Boolean isTicketAvailible() {
        return checkVisibility(flightLine).isDisplayed();
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
