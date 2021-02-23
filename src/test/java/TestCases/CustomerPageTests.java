//package TestCases;
//
//import HelperModels.ProductModel;
//import org.junit.jupiter.api.parallel.ResourceAccessMode;
//import org.junit.jupiter.api.parallel.ResourceLock;
//import org.junit.jupiter.api.parallel.Resources;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class CustomerPageTests extends TestBase{
//    public List<ProductModel> products = new ArrayList<>(Arrays.asList(
//            new ProductModel("Sauce Labs Backpack", 29.99),
//            new ProductModel("Sauce Labs Bolt T-Shirt", 15.99),
//            new ProductModel("Sauce Labs Onesie", 7.99)));
//
////    @Test
////    @Order(2)
////    public void checkCustomersCartProducts(){
////
////        LoginPage loginPage = new LoginPage(driver);
////        InventoryPage inventoryPage = loginPage.navigateToPage().logInTo(User.standard_user).addOrRemoveProducts(products);
////        CustomerCartPage customerPage = inventoryPage.openCustomerCart();
////
////        assertEquals(customerPage.findNumberOfAddedProductFromCustomerCart(products).size(),3);
////
////    }
//}
