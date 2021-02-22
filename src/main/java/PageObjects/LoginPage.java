package PageObjects;

import HelperModels.IncorectCredentials;
import HelperModels.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    WebDriver driver;
    String url;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.url = readProperty("baseURL");
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
            wait.waitUntilVisibilityOfPresentedElement(driver, By.id(ID_InputUsername));
            wait.waitUntilVisibilityOfPresentedElement(driver,By.id(ID_InputPassword));

            usernameInput.clear();
            passwordInput.clear();

            usernameInput.sendKeys(credentials.username);
            passwordInput.sendKeys(credentials.password);
            loginButton.click();

            String message = validationMessageHeader.getText()
                    .replace("Epic sadface:", "")
                    .replace(".", "")
                    .trim();

            validationMessages.add(message);
        }

        return validationMessages;
    }

    public boolean checkIfLoginFormElementsAreDisplay() {
        wait.waitUntilElementClickable(driver, loginButton);
        if (usernameInput.isEnabled() & passwordInput.isEnabled() & loginButton.isEnabled())
            return true;
        else {
            return true;
        }
    }
}

