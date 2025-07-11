package testcases;

import base.BaseTest;
import common.constant.Constant;
import common.driver.DriverManager;
import common.utils.JsonReader;
import common.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Main extends BaseTest{


    @Test
    public static void main(String[] args) {

        PropertyReader reader = new PropertyReader("config.properties");
        String url = reader.getProperty("project.url");
        String browser = reader.getProperty("project.browser");
        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);

       // DriverManager.initDriver();
       // WebDriver driver = DriverManager.getDriver();
       // driver.get(url);
       // driver.manage().window().maximize();

        //Read Json

        String mgs = JsonReader.getJsonValue("message.json", "msg login error");
        System.out.println("Message:" + mgs);

    }

}
