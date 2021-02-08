package PageObjects;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class InventoryPage extends BasePage {
    WebDriver driver;
    String url = "https://www.saucedemo.com/inventory.html/";

    public HeaderSection header;
    public ProductsInventory productsInventory;

    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new HeaderSection(driver);
        this.productsInventory = new ProductsInventory(driver);
    }

    public LoginPage logoutUser() {
        header.burgerButton.click();
        wait.waitUntilElementClickable(driver, header.logoutNav);
        header.logoutNav.click();
        return new LoginPage(driver);
    }
    public Integer getAmountOfPurchasedProductsFromIcon(){
        return Integer.parseInt(header.numbersOfAddedProducts.getText());
    }

    public InventoryPage addProductToCart(Iterator<String> productsName) {
        List<ProductCartPageModel> productCartModels = productsInventory.getProductsCartModel();

        while (productsName.hasNext()) {

            Optional<ProductCartPageModel> model = productCartModels.stream()
                    .filter(product -> product.title.getText().equals(productsName.next()))
                    .findAny();

            model.ifPresent(productCartPageModel -> productCartPageModel.addOrRemoveButton.click());
        }
        return new InventoryPage(driver);
    }

}
