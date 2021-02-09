package TestCases;

import HelperModels.ProductModel;
import HelperModels.User;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPageTests extends TestBase {

     ProductModel product =  new ProductModel("Sauce Labs Backpack", 29.99);

    @Test
    public void addSingleProductFromProductPageAndCheckNumbersOfAddedItems()
    {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.navigateToPage().logInTo(User.standard_user).openProduct(product).addProductToCart(product);

        assertEquals(productPage.header.getAmountOfPurchasedProductsFromIcon(),1);
    }
}
