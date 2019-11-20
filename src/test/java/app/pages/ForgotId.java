package app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotId {

    @FindBy(xpath = "//button")
    public WebElement continueButton;

    @FindBy(partialLinkText = "(877) 974-9774")
    public WebElement phoneSupport;

    public static String getUrl() {
        return "?view=support";
    }

}
