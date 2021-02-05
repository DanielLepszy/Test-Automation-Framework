package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private enum Page {
        loginPage("https://www.saucedemo.com/"),
        inventoryPage("https://www.saucedemo.com/inventory.html");
        String url;

        Page(String url) {
            this.url = url;
        }
    }

    protected void goTo(Page page) {
        driver.get(page.url);
    }
}
