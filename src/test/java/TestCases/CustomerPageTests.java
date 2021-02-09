package TestCases;

import HelperModels.ProductModel;
import PageObjects.CustomerCartPage;
import PageObjects.InventoryPage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerPageTests extends TestBase{
    public Iterator<ProductModel> data = new ArrayList<>(Arrays.asList(
            new ProductModel("Sauce Labs Backpack", 29.99),
            new ProductModel("Sauce Labs Bolt T-Shirt", 15.99))).iterator();

//    @Test
//    @Order(2)
//    public void checkCustomersCartProducts(){
//
//        InventoryPage inventoryPage = new InventoryPage(driver);
//        CustomerCartPage customerPage = inventoryPage.navigateToPage().openCustomerCart();
//
//        assertEquals(customerPage.findNumberOfAddedProductFromCustomerCart(data).size(),2);
//
//    }
}
