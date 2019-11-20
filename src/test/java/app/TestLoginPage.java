package app;

import app.pages.ForgotId;
import app.pages.ForgotPassword;
import app.pages.Login;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage extends AbstractTest {

    @Test
    public void validatePageItself() throws InterruptedException {
        try {
            getHere();
            Login page = PageFactory.initElements(driver, Login.class);
            Assert.assertTrue("Page did not load as https", Login.URLS.contains(driver.getCurrentUrl()));
            Assert.assertEquals("Did not get expected page title", Login.getTitle(mobile),driver.getTitle());
            Assert.assertFalse("Button should not be clickable before entering user/password",checkClickable(page.login));
            page.username.sendKeys("user1");
            Assert.assertFalse("Button should not be clickable before entering password",checkClickable(page.login));
            page.password.sendKeys("correcthorsebatterystaple");
            Assert.assertTrue("Button should be clickable after entering user/password",checkClickable(page.login));
        } finally {
            driver.close();
        }
    }

    @Test
    public void validateForgottenPasswordLink() throws InterruptedException {
        try {
            getHere();

            Login page = PageFactory.initElements(driver, Login.class);
            page.forgotPassword.click();
            Thread.sleep(SLEEP_TIMEOUT);
            Assert.assertEquals("Forgotten password did not link to correct page",
                    baseurl + ForgotPassword.getUrl(),
                    driver.getCurrentUrl());
        } finally {
            driver.close();
        }
    }

    @Test
    public void validateForgottenIdLink() throws InterruptedException {
        try {
            getHere();
            Login page = PageFactory.initElements(driver, Login.class);
            page.forgotId.click();
            Thread.sleep(SLEEP_TIMEOUT);
            Assert.assertEquals("Forgotten password did not link to correct page",
                    baseurl + ForgotId.getUrl(),
                    driver.getCurrentUrl());
        } finally {
            driver.close();
        }
    }

    protected void getHere() throws InterruptedException {
        driver.get("https://app.quore.com/" + (mobile ? Constants.MOBILE : "")); //Verify page loads as HTTPS
        Thread.sleep(SLEEP_TIMEOUT);
        checkTypos(driver);
    }
}
