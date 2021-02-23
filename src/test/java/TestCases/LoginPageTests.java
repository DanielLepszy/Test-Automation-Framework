package TestCases;

import HelperModels.IncorectCredentials;
import HelperModels.User;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTests extends TestBase {

    static Logger log = Logger.getLogger(LoginPageTests.class.getName());

    @Test
    public void loginValidationMessage()
    {
        LoginPage loginPage = new LoginPage(driver);
        log.info("******* INFO FROM CLASS");
        System.out.println("*******INFO FROM STDOUT CLASS******");
        List<String> messages = loginPage.navigateToPage().getInputValidationMessagesDuringWrongLoginProcess();
        assertEquals(messages,IncorectCredentials.getValidationMessage());
    }
//    @Test
//    public void logoutUserFromTheApplicationTest()
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateToPage().logInTo(User.standard_user).logoutUser();
//        assertTrue(loginPage.checkIfLoginFormElementsAreDisplay());
//
//    }

}
