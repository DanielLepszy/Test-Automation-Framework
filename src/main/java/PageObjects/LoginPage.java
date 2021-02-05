package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private static final String ID_InputUsername = "user-name";
    private static final String ID_InputPassword = "password";
    private static final String ID_LoginButton = "login-button";

    @FindBy(id = ID_InputUsername)
    public WebElement usernameInput;

    @FindBy(id = ID_InputPassword)
    public WebElement passwordInput;

    @FindBy(id = ID_LoginButton)
    public WebElement loginButton;

    private enum User {
        standard_user("secret_sauce"),
        locked_out_user("secret_sauce"),
        problem_user("secret_sauce"),
        performance_glitch_user("secret_sauce");
        String password;
        User(String password) {
            this.password = password;
        }
    }

    public InventoryPage logInTo(User user) {
        usernameInput.sendKeys(user.toString());
        usernameInput.sendKeys(user.password);
        loginButton.click();

        return new InventoryPage(driver);
    }
    public LoginPage logInToWrongUser(User user) {
        usernameInput.sendKeys(user.toString());
        usernameInput.sendKeys(user.password);
        loginButton.click();

        return new LoginPage(driver);
    }
}

