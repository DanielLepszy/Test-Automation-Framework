package TestCases;

import HelperModels.ProductModel;
import HelperModels.User;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductPageTests extends TestBase {

     ProductModel product =  new ProductModel("Sauce Labs Backpack", 29.99);

    @Test
    @Order(1)
    public void addSingleProductFromProductPageAndCheckNumbersOfAddedItems()
    {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.navigateToPage().logInTo(User.standard_user).openProduct(product).addOrRemoveProduct(product);
        assertEquals(productPage.header.getAmountOfPurchasedProductsFromIcon(),1);
    }

    @Test
    @Order(2)
    public void removeSingleProductFromProductPageAndCheckNumbersOfAddedItems()
    {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.navigateToPage().logInTo(User.standard_user).openProduct(product).addOrRemoveProduct(product);
        productPage.addOrRemoveProduct(product);

        assertEquals(productPage.header.getAmountOfPurchasedProductsFromIcon(),0);
    }
}
