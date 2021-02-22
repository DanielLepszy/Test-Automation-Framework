package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

public class DriverFactory implements SystemPropertyReader {


    public WebDriver initSession() throws IOException {
        return initBrowser(RunningTypes.Local,Browser.Firefox);
//        return initBrowser(chosenRunningProcess(),chosenBrowser());
    }

    public WebDriver initBrowser(RunningTypes runningTypes, Browser browserType) throws IOException {
        switch (runningTypes) {
            case Local:
                return initBrowserLocally(browserType);
            case Remote:
                return initBrowserRemotely(browserType);

            default:
                throw new IllegalArgumentException("Provider browser doesn't exist");
        }
    }

    public WebDriver initBrowserLocally(Browser browserType) {

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

    public WebDriver initBrowserRemotely(Browser browserType) throws IOException {

        switch (browserType) {
            case Chrome:
                return getRemoteChromeDriver();
            case Firefox:
                return getRemoteFirefoxBrowser();
            default:
                throw new IllegalArgumentException("Provider browser doesn't exist");
        }
    }

    private WebDriver getRemoteFirefoxBrowser() throws IOException {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(readProperty("firefoxBinaryURL"));
        options.setCapability(CapabilityType.PLATFORM, getPlatformFromSystem());
        options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        options.setCapability(CapabilityType.VERSION, getBrowserVersionFromSystem());
        options.setCapability("nodeNumber", getNodeNumber());

        return new RemoteWebDriver(new URL(readProperty("hubURL")), options);
    }



    private WebDriver getRemoteChromeDriver() throws IOException {
        System.setProperty("webdriver.gecko.driver", "./chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.setCapability(CapabilityType.PLATFORM, getPlatformFromSystem());
        options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        options.setCapability(CapabilityType.VERSION, getBrowserVersionFromSystem());
        options.setCapability("nodeNumber", getNodeNumber());
        return new RemoteWebDriver(new URL(readProperty("hubURL")), options);

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
