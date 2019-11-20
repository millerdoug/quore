package app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {

    @FindBy(id="username")
    public WebElement idEntryField;

    @FindBy(xpath = "//button")
    public WebElement continueButton;

    @FindBy(partialLinkText = "(877) 974-9774")
    public WebElement phoneSupport;

    @FindBy(className = "back-to-login")
    public WebElement backToLogin;

    @FindBy(partialLinkText = "Forgot Quore ID?")
    public WebElement forgotId;

    public static String getTitle(boolean mobile) {
        return mobile ? "Quore Login" : "Login | Quore";
    }

    public static String getUrl() {
        return "?view=forgot-password";
    }

}
