package TestCases;

import Drivers.Browser;
import Drivers.DriverFactory;
import Drivers.RunningTypes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class TestBase {
    protected static WebDriver driver;

    //    protected WebDriver getDriver() {
//        if (driver == null)
//            openBrowser();
//        return driver;
//    }
    private static Browser chosenBrowser() {
        String browserType = System.getProperty("BROWSER").toUpperCase();
        List<Browser> browsers = Arrays.asList(Browser.values());
        return browsers.stream()
                .filter(browser -> browser.name().toUpperCase(Locale.ROOT).equals(browserType)).collect(Collectors.toList()).get(0);
    }
    private static RunningTypes chosenRunningProcess() {
        String runningType = System.getProperty("RUNNING_TYPE").toUpperCase();
        List<RunningTypes> types = Arrays.asList(RunningTypes.values());
        return types.stream().filter(type -> type.name().toUpperCase().equals(runningType)).collect(Collectors.toList()).get(0);
    }

    @BeforeAll
    static void openBrowser() throws Exception {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initBrowser(chosenRunningProcess(), chosenBrowser());
//        if(x.equals(Browser.Firefox.name()))
//        {
//            Browser zz = Browser.Firefox;
//            driver = driverFactory.initBrowser(RunningTypes.Local,zz);
//
//        }
    }


    @AfterAll
    static void tearDownSession() {
        driver.close();
    }
}
