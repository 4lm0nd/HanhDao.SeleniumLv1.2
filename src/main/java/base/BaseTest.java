package base;

import common.constant.Constant;
import common.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import common.utils.PropertyReader;
import java.time.Duration;
import static common.utils.LogUtils.info;


public class  BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String url = Constant.reader.getProperty("project.url");
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        waitForPageLoad();
        info("Opened browser and navigated to: " + url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            info("Closed browser.");
        }
    }

    public void waitForPageLoad() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
            );
        } catch (TimeoutException e) {
            info("Page load wait timed out.");
        }
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
