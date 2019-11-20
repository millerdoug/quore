package app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotId {

    @FindBy(xpath = "//button")
    public WebElement continueButton;

    public static String getUrl() {
        return "https://app.quore.com/?view=support";
    }

}
