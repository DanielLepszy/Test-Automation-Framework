package PageObjects;


import WaitFactory.WaitFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage  {

    protected WebDriver driver;
    protected WaitFactory wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitFactory(driver);
        PageFactory.initElements(driver, this);
    }


}
