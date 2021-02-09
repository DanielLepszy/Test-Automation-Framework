package PageObjects;

import HelperModels.ProductModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    WebDriver driver;
    public HeaderSection header;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new HeaderSection(driver);
    }

    static final String CSS_AddToCartButton = ".btn_primary";
    static final String CSS_productPrice = ".inventory_details_price";
    static final String CSS_productName = ".inventory_details_name";
    static final String CSS_productImage = ".inventory_details_img";

    @FindBy(css = CSS_productName)
    public WebElement productTitleElement;

    @FindBy(css = CSS_productPrice)
    public WebElement productPriceElement;

    @FindBy(css = CSS_AddToCartButton)
    public WebElement addOrRemoveButton;

    @FindBy(css = CSS_productImage)
    public WebElement productImageElement;

    private ProductPageModel getProductModelFromPage()
    {
        return  new ProductPageModel(
                productTitleElement,
                productPriceElement,
                addOrRemoveButton,
                productImageElement
        );

    }
    public Boolean checkIfProperProductModelIsOnThePage(ProductModel productModel)
    {
        ProductPageModel productPageModel = getProductModelFromPage();
        if(productPageModel.title.getText().equals(productModel.name) &&
                Double.parseDouble(productPageModel.price.getText())==productModel.price)
        {
            return true;
        }
        else return false;
    }
    public ProductPage addProductToCart(ProductModel productModel) {

        if(checkIfProperProductModelIsOnThePage(productModel))
        {
            addOrRemoveButton.click();
        }
        return new ProductPage(driver);
    }
}
