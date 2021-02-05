package PageObjects;

import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    WebDriver driver;
    public HeaderSection header;

    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new HeaderSection(driver);
    }

    public LoginPage logoutUser(){
        header.burgerButton.click();
        header.logoutNav.click();

        return new LoginPage(driver);
    }
}
