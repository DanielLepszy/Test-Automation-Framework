package TestCases;

import HelperModels.IncorectCredentials;
import HelperModels.User;
import Listener.CustomTestExecutionListener;
import PageObjects.LoginPage;
import Readers.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.beans.PropertyEditor;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LoginPageTests extends TestBase {

    static Logger log = LogManager.getLogger(LoginPageTests.class);

    @Test
    public void loginValidationMessage()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
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
