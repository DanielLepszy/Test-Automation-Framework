package PageObjects;

import HelperModels.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerCartPage extends BasePage {
    WebDriver driver;
    public HeaderSection header;

    public CustomerCartPage(WebDriver driver) {
        super(driver);
        this.header = new HeaderSection(driver);
        this.driver = driver;
    }

    static final String CSS_CheckoutButton = ".cart_footer .checkout_button";
    static final String CSS_ContinueShoppingButton = ".cart_footer .btn_secondary";
    static final String CSS_ProductCartItem = ".cart_item";
    static final String CSS_ProductCartQuantity = ".cart_quantity";
    static final String CSS_ProductNameElement = ".inventory_item_name";
    static final String CSS_ProductPriceElement = ".inventory_item_price";
    static final String CSS_ProductRemoveButton = ".cart_button";


    @FindBy(css = CSS_CheckoutButton)
    public WebElement checkoutButton;

    @FindBy(css = CSS_ContinueShoppingButton)
    public WebElement continueShoppingButton;

    @FindBy(css = CSS_ProductCartItem)
    public List<WebElement> productItems;

    private List<ProductPageModel> getAllAddedProductsFromCustomerCart() {

        List<ProductPageModel> productsList = new ArrayList<>();
        for (WebElement product : productItems) {
            WebElement productQuantity = product.findElement(By.cssSelector(CSS_ProductCartQuantity));
            WebElement productTitle = product.findElement(By.cssSelector(CSS_ProductNameElement));
            WebElement productPice = product.findElement(By.cssSelector(CSS_ProductPriceElement));
            WebElement removeButton = product.findElement(By.cssSelector(CSS_ProductRemoveButton));

            productsList.add(
                    new ProductPageModel(
                            productTitle,
                            productPice,
                            removeButton,
                            productQuantity
                            ));
        }
        return productsList;
    }

    public List<ProductPageModel> findNumberOfAddedProductFromCustomerCart(List<ProductModel> products) {

        List<ProductPageModel> productPageModel = getAllAddedProductsFromCustomerCart();
        List<ProductPageModel> foundProductsModel = new ArrayList<>();

        for (ProductModel productModel:products)
        {
            foundProductsModel.add(productPageModel.stream()
                    .filter(pageModel->
                        pageModel.title.getText().equals(productModel.name)
                        && Double.parseDouble(pageModel.price.getText())==productModel.price)
                    .collect(Collectors.toList()).get(0));
        }
        return foundProductsModel;

    }

}
