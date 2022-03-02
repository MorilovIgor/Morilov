package Homework5;

import org.example.BaseTest;
import org.example.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AuthorizationRiaRuTest extends BaseTest {

    WebDriver driver = DriverManager.getDriver();
    Actions actions = new Actions(driver);
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    @Test
    @DisplayName("Авторизация")
    public void login() {
        driver.get("https://ria.ru");
        Assertions.assertTrue(driver.getTitle().equals("РИА Новости - события в Москве, России и мире сегодня: " +
                "темы дня, фото, видео, инфографика, радио"));

        actions.click(driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")))
                .sendKeys(driver.findElement(By.id("modalAuthEmailField")), getLog())
                .sendKeys(driver.findElement(By.id("modalAuthPassword")), getPwd())
                .click(driver.findElement(By.cssSelector("[tabindex='12']")))
                .build()
                .perform();

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        driver.findElement(By.id("profileLogout")).click();
    }

    @Test
    @DisplayName("Восстановление пароля")
    public void recoverPwd() throws InterruptedException {
        driver.get("https://ria.ru");
        Assertions.assertTrue(driver.getTitle().equals("РИА Новости - события в Москве, России и мире сегодня: " +
                "темы дня, фото, видео, инфографика, радио"));

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        actions.click(driver.findElement(By.cssSelector("[data-modal-open='recovery_password']")))
                .sendKeys(driver.findElement(By.id("modalRecoveryPasswordEmail")), getLog())
                .click(driver.findElement(By.xpath("//button[text()='Продолжить']")))
                .build()
                .perform();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Готово']")).sendKeys(Keys.TAB, Keys.ENTER);

        // новое окно
        driver.get("https://mail.ru");

        actions.click(driver.findElement(By.xpath("(//button[text()='Войти'])[2]")))
                .sendKeys(driver.findElement(By.name("username")), getLog())
                .click(driver.findElement(By.xpath("//span[text()='Ввести пароль']/..")))
                .sendKeys(driver.findElement(By.name("password")), getPwd())
                .click(driver.findElement(By.xpath("//span[text()='Войти']/..")))
                .build()
                .perform();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='РИА Новости']/../../../..")).click();

        Assertions.assertEquals(driver.findElement(By.xpath("(//br)[3]")).getAttribute("textContent"),
                "Здравствуйте! Вы использовали систему восстановления на ria.ru\n" +
                "                    \n" +
                "                Чтобы восстановить пароль, пожалуйста, пройдите по ссылке ниже, нажав на неё или скопировать её в адресную строку браузера: https://ria.ru/id/password_recovery/?secret=d688ee32cf17f85ce2b9f694ace1ea1eЕсли вы не запрашивали восстановление пароля, пожалуйста, проигнорируйте это письмо.\n" +
                "            \n" +
                "                Это автоматическое сообщение.  Пожалуйста, не отвечайте.");

        actions.click(driver.findElement(By.cssSelector(".button2_delete")))
                .click(driver.findElement(By.cssSelector(".ph-project__user-name")))
                .click(driver.findElement(By.xpath("//div[text()='Выйти']/..")))
                .build()
                .perform();

        Assertions.assertTrue(driver.getTitle().equals("Mail.ru: почта, поиск в интернете, новости, игры"));
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
