package PageObjects;

import HelperModels.ProductModel;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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

    public Integer getAmountOfPurchasedProductsFromIcon() {
        try {
             return Integer.parseInt(header.numbersOfAddedProducts.getText());
        } catch (Exception ex) {
            return 0;
        }
    }

    public InventoryPage addProductToCart(Iterator<ProductModel> productsName) {
        List<ProductPageModel> productCartModels = productsInventory.getProductsCartModel();

        while (productsName.hasNext()) {
            ProductModel productModel = productsName.next();
            Optional<ProductPageModel> model = productCartModels.stream()
                    .filter(product -> product.title.getText().trim().equals(productModel.name))
                    .findAny();

            model.ifPresent(productCartPageModel -> productCartPageModel.addOrRemoveButton.click());
        }
        return new InventoryPage(driver);
    }

    public CustomerCartPage openCustomerCart() {
        header.shoppingContainerIcon.click();
        return new CustomerCartPage(driver);
    }
}
