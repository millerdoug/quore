package app;

import app.pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractTest {
    static final int SLEEP_TIMEOUT = 3000;
    private static final String[] typos = new String[]{"Qure", "Quote","Quite","Hostel"};
    private static final String BASE_URL = "https://app.quore.com";
    static final String MOBILE_URL = "/mobile";
    boolean mobile = false;
    WebDriver driver; //Needs help with parallelism

    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=" + System.getProperty("window-size")); //Iphone XR pixel size, possibly: https://www.phonearena.com/phones/Apple-iPhone-XR_id10765
        driver = new ChromeDriver(options);

        mobile = System.getProperty("mobile") != null && Boolean.parseBoolean(System.getProperty("mobile"));
    }

    boolean checkClickable(WebElement webElement) {
        return webElement.getAttribute("Disabled") == null && webElement.getAttribute("disabled") == null;
    }

    protected void login(WebDriver driver, String user, String password) throws InterruptedException {
        //For use in the future
        Login loginPage = start(driver);
        loginPage.username.sendKeys(user);
        loginPage.password.sendKeys(password);
        loginPage.login.click();
    }

    Login start(WebDriver driver) throws InterruptedException {

        driver.get(BASE_URL + (mobile ? MOBILE_URL : ""));
        Login loginPage = PageFactory.initElements(driver, Login.class);

        Thread.sleep(SLEEP_TIMEOUT); //Could possibly handle exception to avoid throwing it in all method signatures
        return loginPage;
    }

    void checkTypos(WebDriver driver) {
        //Override method for exceptions
        for (String s : typos) {
            Assert.assertFalse("Found probable typo: " + s + " on screen " + this.getClass().getSimpleName(), checkExistance(driver, s));
        }
    }

    private boolean checkExistance(WebDriver driver, String elementText) {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + elementText + "')]"));
        list.addAll(driver.findElements(By.xpath("//*[text()='" + elementText + "']")));
        return list != null && !list.isEmpty();
    }

    protected abstract void getHere() throws InterruptedException;
}
