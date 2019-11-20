package app;

import app.pages.Login;
import junit.framework.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AbstractTest {
    static final int SLEEP_TIMEOUT = 2000;
    static final String START_URL = "https://app.quore.com";

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","Downloads/chromedriver-2");
    }

    boolean checkClickable(WebElement webElement) {
        return webElement.getAttribute("Disabled") == null && webElement.getAttribute("disabled") == null;
    }

    protected void login(WebDriver driver) throws InterruptedException {
        //For use in the future
        Login loginPage = start(driver);
        loginPage.username.sendKeys("user1");
        loginPage.password.sendKeys("correcthorsebatterystaple");
        loginPage.login.click();
    }

    protected Login start(WebDriver driver) throws InterruptedException {

        driver.get(START_URL);
        Login loginPage = PageFactory.initElements(driver, Login.class);

        Thread.sleep(SLEEP_TIMEOUT); //Could possibly handle exception to avoid throwing it in all method signatures
        return loginPage;
    }

    public void checkTypos(WebDriver driver) {
        Assert.assertTrue("Found Typo",!checkExistance(driver,"Qure") &&
            !checkExistance(driver,"Quote") &&
            !checkExistance(driver,"Quite") &&
            !checkExistance(driver,"Hostel"));
    }

    private boolean checkExistance(WebDriver driver, String elementText) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + elementText + "')]"));
        list.addAll(driver.findElements(By.xpath("//*[text()='" + elementText + "']")));
        return list != null && !list.isEmpty();
    }
}
