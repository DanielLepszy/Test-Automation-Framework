package TestCases;

import Drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public abstract class TestBase {
    protected static WebDriver driver;


    @BeforeAll
    static void openBrowser() throws Exception {
        PropertyConfigurator.configure("../../../log4j.properties");
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initSession();
    }

//    @AfterAll
//    static void tearDownSession() {
//        driver.close();
//    }
//
    @AfterEach
    void storageCleanup() {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear()");
    }

    //TODO TakeScreenShot
    public void takeScreenShot () {
        driver = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = getClass().getSimpleName();
        System.out.println("ScreenShotName: " + screenshotName);
        try {
            FileUtils.copyFile(srcFile, new File("screenshotName.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
