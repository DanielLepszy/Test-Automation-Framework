package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSection extends BasePage {

    private static final String ID_ShoppingContainerIcon = "shopping_cart_container";
    private static final String CSS_BurgerButton = "#menu_button_container .bm-burger-button button";
    private static final String ID_AllItemsNav = "inventory_sidebar_link";
    private static final String ID_AboutNav = "inventory_sidebar_link";
    private static final String ID_LogoutNav = "logout_sidebar_link";
    private static final String iD_ResetAppStateNav = "inventory_sidebar_link";
    private static final String CSS_NumbersOfAddedProducts = ".shopping_cart_badge";

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = CSS_NumbersOfAddedProducts)
    public WebElement numbersOfAddedProducts;

    @FindBy(id = ID_AllItemsNav)
    public WebElement allItemsNav;

    @FindBy(id = ID_AboutNav)
    public WebElement aboutNav;

    @FindBy(id = ID_LogoutNav)
    public WebElement logoutNav;

    @FindBy(id = iD_ResetAppStateNav)
    public WebElement resetAppStateNav;

    @FindBy(id = ID_ShoppingContainerIcon)
    public WebElement shoppingContainerIcon;

    @FindBy(css = CSS_BurgerButton)
    public WebElement burgerButton;

    public Integer getAmountOfPurchasedProductsFromIcon() {
        try {
            return Integer.parseInt(numbersOfAddedProducts.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

}
