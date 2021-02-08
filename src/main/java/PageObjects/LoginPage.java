package PageObjects;

import Users.IncorectCredentials;
import Users.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private static final String ID_InputUsername = "user-name";
    private static final String ID_InputPassword = "password";
    private static final String ID_LoginButton = "login-button";
    private static final String CSS_ValidationMessageHeader = "h3[data-test='error']";

    @FindBy(css = CSS_ValidationMessageHeader)
    public WebElement validationMessageHeader;

    @FindBy(id = ID_InputUsername)
    public WebElement usernameInput;

    @FindBy(id = ID_InputPassword)
    public WebElement passwordInput;

    @FindBy(id = ID_LoginButton)
    public WebElement loginButton;

    public LoginPage navigateToPage() {
        driver.navigate().to(url);
        return new LoginPage(driver);
    }

    public InventoryPage logInTo(User user) {
        usernameInput.sendKeys(user.name());
        passwordInput.sendKeys(user.password);
        loginButton.click();

        return new InventoryPage(driver);
    }

    public List<String> getInputValidationMessagesDuringWrongLoginProcess() {
        List<String> validationMessages = new ArrayList<>();
        for (IncorectCredentials credentials : IncorectCredentials.values()) {
            usernameInput.clear();
            passwordInput.clear();

            usernameInput.sendKeys(credentials.username);
            passwordInput.sendKeys(credentials.password);
            loginButton.click();

            String message = validationMessageHeader.getText()
                    .replace("Epic sadface:","")
                    .replace(".","")
                    .trim();

            validationMessages.add(message);
        }


        return validationMessages;
    }
}

