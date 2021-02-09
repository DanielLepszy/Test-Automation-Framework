package TestCases;

import HelperModels.ProductModel;
import HelperModels.User;
import PageObjects.CustomerCartPage;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerPageTests extends TestBase{
    public List<ProductModel> products = new ArrayList<>(Arrays.asList(
            new ProductModel("Sauce Labs Backpack", 29.99),
            new ProductModel("Sauce Labs Bolt T-Shirt", 15.99),
            new ProductModel("Sauce Labs Onesie", 7.99)));

//    @Test
//    @Order(2)
//    public void checkCustomersCartProducts(){
//
//        LoginPage loginPage = new LoginPage(driver);
//        InventoryPage inventoryPage = loginPage.navigateToPage().logInTo(User.standard_user).addOrRemoveProducts(products);
//        CustomerCartPage customerPage = inventoryPage.openCustomerCart();
//
//        assertEquals(customerPage.findNumberOfAddedProductFromCustomerCart(products).size(),3);
//
//    }
}
