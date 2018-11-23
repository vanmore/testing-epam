package by.van;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MainTest {
    WebDriver driver;

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.gecko.driver","resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.icelandair.com/ru-ru/");
    }

    @Test
    public void getNotFoundWarningOnInvalidFromCity() {
        WebElement element=driver.findElement(By.xpath("//input[@placeholder='Вылетает из...']"));
        element.sendKeys("Muhograd");

        Boolean warningIsPresent = driver
                .findElements(By.xpath("//div[text()='Не найдено ни одного результата']"))
                .size() > 0;
        Assert.assertTrue(warningIsPresent);
    }

    @AfterClass
    public void close() {
        driver.close();
    }
}