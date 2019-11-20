package app;

import app.pages.ForgotId;
import app.pages.ForgotPassword;
import app.pages.Login;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


public class TestForgottenPasswordPage extends AbstractTest {

    @Test
    public void validatePageItself() throws InterruptedException {
        try {
            getHere();
            ForgotPassword forgottenPwd = PageFactory.initElements(driver,ForgotPassword.class);
            Assert.assertEquals("Page title incorrect",ForgotPassword.getTitle(mobile),driver.getTitle());
            Assert.assertFalse("Continue should not be clickable before entering id",checkClickable(forgottenPwd.continueButton));
            forgottenPwd.idEntryField.sendKeys("someId");
            Assert.assertTrue("Continue button should be clickable after entering id", checkClickable(forgottenPwd.continueButton));
        } finally {
            driver.close();
        }
    }

    @Test
    public void validateLinkToForgottenId() throws InterruptedException {
        try {
            getHere();
            ForgotPassword forgottenPwd = PageFactory.initElements(driver,ForgotPassword.class);
            forgottenPwd.forgotId.click();
            Thread.sleep(SLEEP_TIMEOUT);
            Assert.assertEquals("Failed to navigate to forgotten Id page from forgotten password",
                    Constants.BASE_URL + (mobile ? Constants.MOBILE : "") + ForgotId.getUrl(),
                    driver.getCurrentUrl());
        } finally {
            driver.close();
        }
    }

    @Test
    public void validateLinkToLogin() throws InterruptedException {
        try {
            getHere();
            ForgotPassword forgottenPwd = PageFactory.initElements(driver,ForgotPassword.class);
            forgottenPwd.backToLogin.click();
            Thread.sleep(SLEEP_TIMEOUT);
            Assert.assertTrue("Failed to navigate back to login forgotten password",Login.URLS.contains(driver.getCurrentUrl()));
        } finally {
            driver.close();
        }
    }

    protected void getHere() throws InterruptedException {
        Login loginPage = start(driver);
        loginPage.forgotPassword.click();
        checkTypos(driver);
        Thread.sleep(SLEEP_TIMEOUT);
    }
}
