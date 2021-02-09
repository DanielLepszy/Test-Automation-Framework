package TestCases;

import Drivers.Browser;
import Drivers.DriverFactory;
import WaitFactory.WaitFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
    protected static WebDriver driver;

//    protected WebDriver getDriver() {
//        if (driver == null)
//            openBrowser();
//        return driver;
//    }
    @BeforeAll
    static void openBrowser() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initBrowser(Browser.Firefox);
    }


    @AfterAll
    static void tearDownSession() {
        driver.close();
    }
}
