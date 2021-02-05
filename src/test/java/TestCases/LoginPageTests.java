package TestCases;

import PageObjects.LoginPage;
import Users.IncorectCredentials;
import Users.User;
import org.junit.jupiter.api.Test;

import java.util.List;


public class LoginPageTests extends TestBase {

    @Test
    public void loginValidationMessage()
    {
        LoginPage loginPage = new LoginPage(driver);
        List<String> messages = loginPage.navigateToPage().getInputValidationMessagesDuringWrongLoginProcess();
        //TODO check why list is not equal
        assert  messages == IncorectCredentials.getValidationMessage();
    }

//    @Test
//    public void logoutUserFromTheApplicationTest()
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateToPage().logInTo(User.standard_user).logoutUser();
//    }

}
