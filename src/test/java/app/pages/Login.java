package app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class Login {
    public static ArrayList<String> URLS = new ArrayList<String>() {
        {
            add("https://app.quore.com/");
            add("https://app.quore.com/?view=login-form");
        }
    };
    public static String TITLE = "Login | Quore";

    @FindBy(linkText = "Forgot Quore ID?")
    public WebElement forgotId;

    @FindBy(linkText = "Forgot password?")
    public WebElement forgotPassword;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement login;
}
