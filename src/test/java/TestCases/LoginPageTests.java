package TestCases;

import HelperModels.IncorectCredentials;
import HelperModels.User;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginPageTests extends TestBase {


    @Test
    public void loginValidationMessage()
    {
        LoginPage loginPage = new LoginPage(driver);
        List<String> messages = loginPage.navigateToPage().getInputValidationMessagesDuringWrongLoginProcess();
        assertEquals(messages,IncorectCredentials.getValidationMessage());
    }

    @Test
    public void logoutUserFromTheApplicationTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage().logInTo(User.standard_user).logoutUser();
        assertTrue(loginPage.checkIfLoginFormElementsAreDisplay());
    }

}
