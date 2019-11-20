package app.pages;

import app.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class Login {
    public static ArrayList<String> URLS = new ArrayList<String>() {
        {
            add(Constants.BASE_URL);
            add(Constants.BASE_URL + "?view=login-form");
            add(Constants.BASE_URL + Constants.MOBILE);
            add(Constants.BASE_URL + Constants.MOBILE + "?view=login-form");
        }
    };

    public static String getTitle(boolean mobile) {
        return mobile ? "Quore Login" : "Login | Quore";
    }

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

    @FindBy(partialLinkText = "Learn what Quore can do for your hotel.")
    public WebElement learnMore;

}
