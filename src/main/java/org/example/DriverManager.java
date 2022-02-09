package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static ChromeOptions configChrome() {

        ChromeOptions options = new ChromeOptions();

        WebDriverManager.chromedriver().setup();

        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        return options;
    }

    private static WebDriver driver;

    private static void setDriver() {
        driver = new ChromeDriver(configChrome());
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            setDriver();
        }
        return driver;
    }
}
