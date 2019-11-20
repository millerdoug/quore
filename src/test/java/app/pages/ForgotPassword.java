package app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {

    @FindBy(id="username")
    public WebElement idEntryField;

    @FindBy(xpath = "//button")
    public WebElement continueButton;

    @FindBy(className = "back-to-login")
    public WebElement backToLogin;

    @FindBy(partialLinkText = "Forgot Quore ID?")
    public WebElement forgotId;

    public static String getTitle() {
        return "Login | Quore";
    }

    public static String getUrl() {
        return "https://app.quore.com/?view=forgot-password";
    }

}
