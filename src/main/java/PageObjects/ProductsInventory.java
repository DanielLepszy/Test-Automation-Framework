package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsInventory extends BasePage {
    WebDriver driver;

    public ProductsInventory(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    static final String CSS_ProductCart = ".inventory_list .inventory_item";
    static final String CSS_ProductTitle = ".inventory_item_name";
    static final String CSS_ProductPrice = ".inventory_item_price";
    static final String CSS_ProductImage = ".inventory_item_img";
    static final String TagName_AddOrRemoveItemButton = "button";


    @FindAll({@FindBy(css = CSS_ProductCart)})
    @CacheLookup
    public List<WebElement> productCartsElement;

    public List<ProductCartPageModel> getProductsCartModel() {
        List<ProductCartPageModel> productCartModels = new ArrayList<>();
        for (WebElement cart : productCartsElement) {

            WebElement productImage = cart.findElement(By.cssSelector(CSS_ProductImage));
            WebElement productTitle = cart.findElement(By.cssSelector(CSS_ProductTitle));
            WebElement productPrice = cart.findElement(By.cssSelector(CSS_ProductPrice));
            WebElement addOrRemoveButton = cart.findElement(By.tagName(TagName_AddOrRemoveItemButton));

            productCartModels.add(
                    new ProductCartPageModel(
                            productTitle,
                            productPrice,
                            addOrRemoveButton,
                            productImage

                            ));

        }
        return productCartModels;
    }
}

class ProductCartPageModel {

    public ProductCartPageModel(WebElement titleElement, WebElement priceElement, WebElement addOrRemoveButton, WebElement productImage) {
        this.title = titleElement;
        this.price = priceElement;
        this.addOrRemoveButton = addOrRemoveButton;
        this.productImage = productImage;
    }

    WebElement title;
    WebElement price;
    WebElement addOrRemoveButton;
    WebElement productImage;
}
