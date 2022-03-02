package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver = DriverManager.getDriver();

    private String log = "mr_qa@bk.ru";
    private String pwd = "&zCROiTuty11";
    private String wrongLog = "111@111";
    private String wrongPwd = "1111";

    public String getLog() {
        return log;
    }

    public String getPwd() {
        return pwd;
    }

    public String getWrongLog() {
        return wrongLog;
    }

    public String getWrongPwd() {
        return wrongPwd;
    }

    @BeforeEach
    public void sleep() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
