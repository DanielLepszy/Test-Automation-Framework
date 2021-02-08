package TestCases;

import HelperModels.ProductModel;
import HelperModels.User;
import PageObjects.CustomerCartPage;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InventoryPageTests extends TestBase {

    public Iterator<ProductModel> data = new ArrayList<>(Arrays.asList(
            new ProductModel("Sauce Labs Backpack", 29.99),
            new ProductModel("Sauce Labs Bolt T-Shirt", 15.99))).iterator();

    @Test
    @Order(1)
    public void addSingleProductToCartAndRemove()
    {
        LoginPage loginPage = new LoginPage(driver);
        Integer purchasedProducts = loginPage.navigateToPage().logInTo(User.standard_user).addProductToCart(data).getAmountOfPurchasedProductsFromIcon();

        assertEquals(purchasedProducts,2);
    }

    @Test
    @Order(2)
    public void checkCustomersCartProducts(){

        InventoryPage inventoryPage = new InventoryPage(driver);
        CustomerCartPage customerPage = inventoryPage.openCustomerCart();

        assertEquals(customerPage.findNumberOfAddedProductFromCustomerCart(data).size(),1);

    }
}
