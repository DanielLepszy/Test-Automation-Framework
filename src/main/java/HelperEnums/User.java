package HelperEnums;

public enum User {
    standard_user("secret_sauce"),
    locked_out_user("secret_sauce"),
    problem_user("secret_sauce"),
    performance_glitch_user("secret_sauce");

    public String password;

    User(String password) {
        this.password = password;
    }
}