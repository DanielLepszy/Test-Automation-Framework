package TestCases;

import Drivers.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
    protected static WebDriver driver;

    @BeforeAll
    static void openBrowser() throws Exception {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initSession();
    }

    @AfterAll
    static void tearDownSession() {
        driver.close();
    }
}
