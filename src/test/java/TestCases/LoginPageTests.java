package TestCases;

import HelperModels.IncorectCredentials;
import HelperModels.User;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
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
