package Homework5;

import org.example.BaseTest;
import org.example.DriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AuthorizationRiaRuTest extends BaseTest {

    WebDriver driver = DriverManager.getDriver();
    Actions actions = new Actions(driver);

    @Test
    @DisplayName("Авторизация")
    public void login() {
        driver.get("https://ria.ru");

        // как обратиться к элементам???
        actions
                .click()
                .build()
                .perform();
    }

    @Test
    @DisplayName("Восстановление пароля")
    public void recoverPwd() {

    }

    @Test
    @DisplayName("Неверные данные")
    public void wrongAuthorization() {

    }

    @Test
    @DisplayName("Неверный логин")
    public void wrongLogin() {

    }
}
