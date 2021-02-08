package TestCases;

import PageObjects.LoginPage;
import Users.IncorectCredentials;
import Users.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTests extends TestBase {

    @Test
    public void loginValidationMessage()
    {
        LoginPage loginPage = new LoginPage(driver);
        List<String> messages = loginPage.navigateToPage().getInputValidationMessagesDuringWrongLoginProcess();
        assertEquals(messages,IncorectCredentials.getValidationMessage());


    }



//    @Test
//    public void logoutUserFromTheApplicationTest()
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateToPage().logInTo(User.standard_user).logoutUser();
//    }

}
