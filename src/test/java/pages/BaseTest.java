package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.Waits;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     *
     * @param locator
     */
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void clear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void waitForElement(By locator, Waits wait){
        switch (wait){
            case CLICKABLE -> this.wait.until(ExpectedConditions.elementToBeClickable(locator));
            case VISIBILITY -> this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            default -> this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }

}
