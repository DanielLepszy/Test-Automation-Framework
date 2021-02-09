package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

public class DriverFactory {

    public WebDriver initBrowser(Browser browserType) {

        switch (browserType) {
            case Chrome:
                return getChromeDriver();
            case Firefox:
                return getFirefoxBrowser();

            default:
                throw new IllegalArgumentException("Provider browser doesn't exist");
        }
    }

    private WebDriver getFirefoxBrowser() {
//        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver","C:/Users/Daniel_Lepszy/Tools/Drivers/geckodriver.exe");

        return new FirefoxDriver();
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }

}
