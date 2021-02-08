package HelperEnums;

import java.util.ArrayList;
import java.util.List;

public enum IncorectCredentials {
    locked_user_credentials("locked_out_user","secret_sauce","Sorry, this user has been locked out"),
    empty_username("","secret_sauce","Username is required"),
    empty_password("username","","Password is required"),
    empty_credentials("","","Username is required"),
    incorrect_credentials("incorrect","incorrect ","Username and password do not match any user in this service");

    public String username;
    public String password;
    public String message;
    public static List<String> getValidationMessage()
    {
        List<String> validationMessages = new ArrayList<>();
        for (IncorectCredentials validation: IncorectCredentials.values()){
            validationMessages.add(validation.message);
        }
        return validationMessages;
    }

    IncorectCredentials(String username, String password, String message) {
        this.username = username;
        this.password = password;
        this.message = message;
    }
}
