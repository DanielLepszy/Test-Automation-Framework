package TestCases;

import HelperModels.User;
import PageObjects.LoginPage;
import com.google.common.collect.Iterators;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryPageTests extends TestBase {
    
    @Test
    public void addSingleProductToCartAndRemove()
    {
        Iterator<String> productsName = new ArrayList<>(Collections.singletonList("Sauce Labs Backpack")).iterator();
        LoginPage loginPage = new LoginPage(driver);
        Integer purchasedProducts = loginPage.navigateToPage().logInTo(User.standard_user).addProductToCart(productsName).getAmountOfPurchasedProductsFromIcon();

        assertEquals(purchasedProducts,1);
    }
}
