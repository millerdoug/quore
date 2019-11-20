package app;

import app.pages.ForgotId;
import app.pages.ForgotPassword;
import app.pages.Login;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage extends AbstractTest {

    @Test
    public void validatePageItself() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("http://app.quore.com");

            Thread.sleep(SLEEP_TIMEOUT);
            checkTypos(driver);

            Login page = PageFactory.initElements(driver, Login.class);
            Assert.assertTrue("Page did not load as https", Login.URLS.contains(driver.getCurrentUrl()));
            Assert.assertEquals("Did not get expected page title", Login.TITLE,driver.getTitle());
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
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("http://app.quore.com");

            Thread.sleep(SLEEP_TIMEOUT);
            checkTypos(driver);

            Login page = PageFactory.initElements(driver, Login.class);
            page.forgotPassword.click();
            Thread.sleep(SLEEP_TIMEOUT);
            Assert.assertEquals("Forgotten password did not link to correct page", ForgotPassword.getUrl(),driver.getCurrentUrl());
        } finally {
            driver.close();
        }
    }

    @Test
    public void validateForgottenIdLink() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("http://app.quore.com");

            Thread.sleep(SLEEP_TIMEOUT);
            checkTypos(driver);

            Login page = PageFactory.initElements(driver, Login.class);
            page.forgotId.click();
            Thread.sleep(SLEEP_TIMEOUT);
            Assert.assertEquals("Forgotten password did not link to correct page", ForgotId.getUrl(),driver.getCurrentUrl());
        } finally {
            driver.close();
        }
    }
}
