package TestCases;

import Drivers.Browser;
import Drivers.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
    protected WebDriver driver;

//    protected WebDriver getDriver() {
//        if (driver == null)
//            openBrowser();
//        return driver;
//    }

    @BeforeEach
    public void openBrowser() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initBrowser(Browser.Firefox);
    }

    @AfterEach
    public void tearDownSession() {
        driver.close();
    }
}
