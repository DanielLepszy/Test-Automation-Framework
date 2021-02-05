package PageObjects;

import Drivers.Browser;
import Drivers.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    @BeforeEach
    public void openBrowser(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initBrowser(Browser.Firefox);
    }

    @AfterAll
    public void tearDown(){
        driver.close();
    }
}
