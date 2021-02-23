//package TestCases;
//
//import HelperModels.ProductModel;
//import HelperModels.User;
//import PageObjects.InventoryPage;
//import PageObjects.LoginPage;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.parallel.ResourceAccessMode;
//import org.junit.jupiter.api.parallel.ResourceLock;
//import org.junit.jupiter.api.parallel.Resources;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class InventoryPageTests extends TestBase {
//
//    public List<ProductModel> products = new ArrayList<>(Arrays.asList(
//            new ProductModel("Sauce Labs Backpack", 29.99),
//            new ProductModel("Sauce Labs Bolt T-Shirt", 15.99)));
//
//    @Test
//    @Order(1)
//    public void checkIfProductImageShowUpOnPage()
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        InventoryPage inventoryPage = loginPage.navigateToPage().logInTo(User.standard_user);
//        assertTrue(inventoryPage.checkIfAllProductImagesAreVisibility());
//    }
//
//    @Test
//    @Order(2)
//    public void addTwoProductToCartAndCheckNumberOfProductInTrolleyIcon()
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        InventoryPage inventoryPage = loginPage.navigateToPage().logInTo(User.standard_user).addOrRemoveProducts(products);
//        Integer purchasedProducts = inventoryPage.header.getAmountOfPurchasedProductsFromIcon();
//
//        assertEquals(purchasedProducts,2);
//    }
//
//    @Test
//    @Order(3)
//    public void removeTwoProductsAndCheckNumberOfProductInTrolleyIcon()
//    {
//        InventoryPage inventoryPage = new InventoryPage(driver);
//        inventoryPage.addOrRemoveProducts(products);
//        Integer purchasedProducts = inventoryPage.header.getAmountOfPurchasedProductsFromIcon();
//
//        assertEquals(purchasedProducts,0);
//    }
//
//}
