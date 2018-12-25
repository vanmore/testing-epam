package by.van.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckinPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//strong[contains(@class, 'message-title')]")
    public WebElement messageTitle;

    public CheckinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public String getMessageTitle() {
        return checkVisibility(messageTitle).getText();
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
