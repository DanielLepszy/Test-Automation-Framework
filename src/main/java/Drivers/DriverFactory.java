package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public WebDriver initBrowser(RunningTypes runningTypes, Browser browserType) throws MalformedURLException {
        switch (runningTypes) {
            case Local:
                return initBrowserLocally(browserType);
            case Remote:
                return initBrowserRemotely(browserType);

            default:
                throw new IllegalArgumentException("Provider browser doesn't exist");
        }
    }

    public WebDriver initBrowserLocally(Browser browserType) throws MalformedURLException {

        switch (browserType) {
            case Chrome:
                return getLocalChromeBrowser();
            case Firefox:
                return getLocalFirefoxBrowser();
            case Edge:
                return getLocalEdgeBrowser();

            default:
                throw new IllegalArgumentException("Provider browser doesn't exist");
        }
    }

    public WebDriver initBrowserRemotely(Browser browserType) throws MalformedURLException {

        switch (browserType) {
            case Chrome:
                return getRemoteChromeDriver();
            case Firefox:
                return getRemoteFirefoxBrowser();
            default:
                throw new IllegalArgumentException("Provider browser doesn't exist");
        }
    }

    private WebDriver getRemoteFirefoxBrowser() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        options.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        options.setCapability(CapabilityType.VERSION, "85.0");

        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    private WebDriver getRemoteChromeDriver() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "./chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        options.setCapability(CapabilityType.VERSION, "88.0");

        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

    }

    private WebDriver getLocalEdgeBrowser() {
        WebDriverManager.edgedriver().setup();

        return new EdgeDriver();
    }

    private WebDriver getLocalFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();

        return new FirefoxDriver();
    }

    private WebDriver getLocalChromeBrowser() {
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver();
    }

}
