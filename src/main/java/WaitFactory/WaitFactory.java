package WaitFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;


public class WaitFactory {

    WebDriver driver;
    Duration timeInSec = Duration.ofSeconds(3);

    public WaitFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisibilityOfElement(WebDriver drv, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(drv, timeInSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementClickable(WebDriver drv, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(drv, timeInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilVisibilityOfPresentedElement(WebDriver drv, By locator)
    {
        WebDriverWait wait = new WebDriverWait(drv, timeInSec);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}
