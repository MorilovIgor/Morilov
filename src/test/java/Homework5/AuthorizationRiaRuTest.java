package Homework5;

import org.example.BaseTest;
import org.example.DriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AuthorizationRiaRuTest extends BaseTest {

    WebDriver driver = DriverManager.getDriver();

    @Test
    @DisplayName("Авторизация")
    public void login() {

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
