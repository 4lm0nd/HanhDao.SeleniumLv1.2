package common.driver;

import common.constant.Constant;
import enums.Browsers;
import common.utils.PropertyReader;
import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {
            PropertyReader reader = new PropertyReader("config.properties");
            Browsers browser = Browsers.valueOf(reader.getProperty("project.browser").toUpperCase());
            driver.set(BrowserFactory.createDriver(browser));
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("WebDriver Not Started Yet.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
