package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSection extends BasePage {

    private static final String ID_ShoppingContainerIcon = "shopping_cart_container";

    @FindBy(id = ID_ShoppingContainerIcon)
    public WebElement shoopingContainerIcon;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }
}
