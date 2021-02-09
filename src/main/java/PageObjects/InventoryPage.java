package PageObjects;

import HelperModels.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public InventoryPage navigateToPage() {
        driver.navigate().to(url);
        return new InventoryPage(driver);
    }

    public LoginPage logoutUser() {
        header.burgerButton.click();
        wait.waitUntilElementClickable(driver, header.logoutNav);
        header.logoutNav.click();
        return new LoginPage(driver);
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


    private List<WebElement> getProductImagesOnPage() {
        List<ProductPageModel> productCartModels = productsInventory.getProductsCartModel();

        return productCartModels.stream()
                .map(element->element.productImage)
                .collect(Collectors.toList());
    }

    public boolean checkIfAllProductImagesAreVisibility()
    {
        List<WebElement> elements = getProductImagesOnPage();
        try {
            elements.forEach(element ->
                    wait.waitUntilVisibilityOfElement(driver,element));
            return true;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public ProductPage openProduct(ProductModel productModel) {
        List<ProductPageModel> productPageModel = productsInventory.getProductsCartModel();

        ProductPageModel product = productPageModel.stream()
                .filter(el->el.title.getText().equals(productModel.name))
                .collect(Collectors.toList()).get(0);

        product.title.click();

        return new ProductPage(driver);

    }
}
