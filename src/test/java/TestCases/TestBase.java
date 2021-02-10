package TestCases;

import Drivers.Browser;
import Drivers.DriverFactory;
import Drivers.RunningTypes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class TestBase {
    protected static WebDriver driver;

//    protected WebDriver getDriver() {
//        if (driver == null)
//            openBrowser();
//        return driver;
//    }
    @BeforeAll
    static void openBrowser() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initBrowser(RunningTypes.Remote,Browser.Chrome);
    }


    @AfterAll
    static void tearDownSession() {
        driver.close();
    }
}
